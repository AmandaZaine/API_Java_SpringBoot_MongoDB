# API_Java_SpringBoot_MongoDB

POC baseada no [Curso Desenvolvendo APIs com Java, Spring Boot e MongoDB](https://youtube.com/playlist?list=PL5X822QTM1JYvV-osYuBH9FBq5rOO81Ea&feature=shared)

### Objetivo
* Criação de uma API REST / CRUD simples para manipulação da entidade Aluno.

### Tecnologias usadas
* Java 21
* SpringBoot 
* MongoDB 
* Spring Cloud OpenFeign usado [para consumir uma API de busca de CEPs](https://brasilapi.com.br/)
* JSON
  
### Padrões implementados
* [DTO (Data Transfer Object)](https://fullcycle.com.br/o-que-e-dto/): Usado para transferir dados entre camadas ou serviços.

### Arquitetura usada
* [REST](https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api) (GET, POST, PUT, DELETE, PATCH)
*  Arquitetura em camadas MVC (Model-View-Controller)
    * Controller:  Camada de interface com o usuário. Onde recebemos as solicitações.
    * Service: Camada de negócios ou aplicação. Contém a lógica de negócio e gerencia as operações entre os repositórios e os controladores.
    * Repository: Camada de persistência de dados. Contém métodos que interagem diretamente com o banco de dados.
    * Model: Camada de domínio ou as entidades (representações de dados mapeadas para o banco de dados).
    * DTO: Serve como intermediário para transferir dados de forma eficiente.

<!-- Endpoints criados: -->