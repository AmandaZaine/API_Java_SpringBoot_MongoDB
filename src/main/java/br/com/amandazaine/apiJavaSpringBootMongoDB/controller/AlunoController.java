package br.com.amandazaine.apiJavaSpringBootMongoDB.controller;

import br.com.amandazaine.apiJavaSpringBootMongoDB.dto.AlunoDTO;
import br.com.amandazaine.apiJavaSpringBootMongoDB.httpClient.CepHttpClient;
import br.com.amandazaine.apiJavaSpringBootMongoDB.model.Aluno;
import br.com.amandazaine.apiJavaSpringBootMongoDB.model.Endereco;
import br.com.amandazaine.apiJavaSpringBootMongoDB.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/alunos")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @Autowired
    CepHttpClient cepHttpClient;

    @GetMapping
    public List<Aluno> findAll() {
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable String id) {
        Optional<Aluno> aluno = alunoService.findById(id);

        //return aluno.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());

        if(aluno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(aluno.get());
    }

    @PostMapping
    public ResponseEntity<Aluno> insert(@RequestBody @Valid AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO);

        Endereco endereco = cepHttpClient.findEndereco(alunoDTO.getCep());

        aluno.setEndereco(endereco);

        Aluno novoAluno = alunoService.insert(aluno);
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@RequestBody AlunoDTO novosDadosAluno, @PathVariable String id) {
        Aluno aluno = new Aluno(novosDadosAluno);

        Endereco endereco = cepHttpClient.findEndereco(novosDadosAluno.getCep());

        aluno.setEndereco(endereco);

        Aluno alunoUpdated = alunoService.update(aluno, id);

        return alunoUpdated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> delete(@PathVariable String id) {
        Boolean statusDelete = alunoService.delete(id);

        if(!statusDelete){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(null);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Aluno> updateCpf(@RequestParam("cpf") String cpf, @PathVariable String id) {
        Aluno aluno = alunoService.updateCpf(cpf, id);

        return aluno == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(aluno);
    }
}
