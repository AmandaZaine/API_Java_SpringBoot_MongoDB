package br.com.amandazaine.apiJavaSpringBootMongoDB.services;

import br.com.amandazaine.apiJavaSpringBootMongoDB.model.Aluno;
import br.com.amandazaine.apiJavaSpringBootMongoDB.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(String id) {
        return alunoRepository.findById(id);
    }

    public Aluno insert(Aluno aluno) {
        return alunoRepository.insert(aluno);
    }

    public Aluno update(Aluno novosDadosAluno, String id) {
        Optional<Aluno> optionalAluno = findById(id);

        if(optionalAluno.isPresent()){
            Aluno aluno = optionalAluno.get();
            aluno.setNome(novosDadosAluno.getNome());
            aluno.setSobrenome(novosDadosAluno.getSobrenome());
            aluno.setCpf(novosDadosAluno.getCpf());
            aluno.setEndereco(novosDadosAluno.getEndereco());
            return alunoRepository.save(aluno);
        }

        return null;
    }

    public Boolean delete(String id) {
        Optional<Aluno> aluno = findById(id);

        if(aluno.isPresent()) {
            alunoRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Aluno updateCpf(String cpf, String id) {
        Optional<Aluno> optionalAluno = findById(id);

        if(optionalAluno.isPresent()){
            Aluno aluno = optionalAluno.get();
            aluno.setCpf(cpf);
            return alunoRepository.save(aluno);
        }

        return null;
    }
}
