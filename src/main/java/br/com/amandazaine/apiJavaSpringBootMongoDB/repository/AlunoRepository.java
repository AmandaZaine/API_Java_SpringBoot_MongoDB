package br.com.amandazaine.apiJavaSpringBootMongoDB.repository;

import br.com.amandazaine.apiJavaSpringBootMongoDB.model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AlunoRepository extends MongoRepository<Aluno, String> {

    public List<Aluno> findByNome(String nome);
    public List<Aluno> findByNomeNot(String nome);
    public List<Aluno> findByNomeAndSobrenome(String nome, String sobrenome);

    @Query("{ $or: [ {sobrenome: ?0}, {cpf: ?1} ] }")
    public List<Aluno> encontrarPorSobrenomeOuCpf(String sobrenome, String cpf);
}
