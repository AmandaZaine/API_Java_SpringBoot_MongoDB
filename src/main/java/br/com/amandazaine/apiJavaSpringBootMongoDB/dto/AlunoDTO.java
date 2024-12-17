package br.com.amandazaine.apiJavaSpringBootMongoDB.dto;

import jakarta.validation.constraints.NotEmpty;

public class AlunoDTO {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @NotEmpty
    private String cpf;

    private String cep;

    public AlunoDTO() {
    }

    public AlunoDTO(String nome, String sobrenome, String cpf, String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.cep = cep;
    }

    public @NotEmpty String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty String nome) {
        this.nome = nome;
    }

    public @NotEmpty String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(@NotEmpty String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public @NotEmpty String getCpf() {
        return cpf;
    }

    public void setCpf(@NotEmpty String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
