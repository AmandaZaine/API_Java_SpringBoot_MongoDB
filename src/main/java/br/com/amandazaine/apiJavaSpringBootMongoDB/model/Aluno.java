package br.com.amandazaine.apiJavaSpringBootMongoDB.model;

import br.com.amandazaine.apiJavaSpringBootMongoDB.dto.AlunoDTO;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aluno")
public class Aluno {

    @Id
    private String id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @NotEmpty
    private String cpf;

    private Endereco endereco;

    public Aluno() {
    }

    public Aluno(String id, String nome, String sobrenome, String cpf, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Aluno(AlunoDTO alunoDTO) {
        this.setNome(alunoDTO.getNome());
        this.setSobrenome(alunoDTO.getSobrenome());
        this.setCpf(alunoDTO.getCpf());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
