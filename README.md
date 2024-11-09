# Employee Microservice

## Descrição

Este projeto é um microserviço para gerir funcionários e todas as suas responsabilidades, desenvolvido utilizando Spring Boot. 

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **JavaDoc**: Documentação do código para futuros desenvolvedores.
- **MySQL**: Utilizado como banco de dados.
- **Docker**: A aplicação foi containerizada para ser mais ágil e facil de testar e implementar.
- **Docker-compose**: Foi adicionado um docker-compose para a containerização das diferentes ferramentas que compõem o sistema.
- **Lombok**: Biblioteca utilizada para reduzir o código boilerplate da aplicação.
- **Swagger**: Documentação dos DTO's, descriçao do projeto e dos endpoints. 
- **Conceitos**: Clean Code, Clean Architecture, REST.
- **Flyway**: Versionamento do banco de dados com Flyway.
- **H2 Database**: Banco de dados utilizado para testes unitários.
- **JUnit 5**: Biblioteca utilizada para realizar os testes unitários do sistema. 
- **JPA Auditing**: Controle de criação e atualização das entidades automática.
- **GitHub Actions**: Integração contínua automatizada para testar, compilar e gerar uma imagem para o Docker Hub.

## Funcionalidades

A API permite as seguintes operações:

### Employee

- **createNewEmployee**: Criar um novo funcionário a partir das informações passadas pelo EmployeeDTO.
- **updateEmployee**: Atualizar as informações de um funcionário salvo.
- **fetchEmployeeById**: Busca um funcionário salvo pelo seu ID.
- **fetchEmployeeByEmail**: Busca um funcionário salvo pelo seu email.
- **fetchEmployeeByCellphone**: Busca um funcionário salvo pelo seu celular cadastrado.
- **fetchEmployeesList**: Busca todos os funcionários cadastrados no sistema.
- **inactivateEmployee**: inativa um funcionário pelo seu ID, mudando seu status no banco de dados para I.

## Estrutura do Projeto

A estrutura do projeto segue os princípios de Clean Architecture, garantindo que o código seja modular, fácil de manter e escalável.

## Implementações Futuras
- Testes unitários do service layer.
- Testes unitários do controller layer.
- Testes de integração.

## Testando a API
Utilize o Swagger para verificar a documentação e testar os endpoints da API através do link:
http://localhost:8080/swagger-ui/index.html#

### Endpoints:

### Employee:
- **POST** /api/v1/employee/create-employee: Cria um novo funcionário.
- **PUT** /api/v1/employee/profile/{employeeId}: Atualiza um funcionário existente.
- **GET** /api/v1/employee/list: Busca todos os funcionários salvos no banco de dados e retorna uma lista com os registros.
- **GET** /api/v1/employee: Buscar um funcionário pelo ID, e retorna seu objeto salvo.
- **GET** /api/v1/employee/email: Buscar um funcionário pelo seu email, e retorna seu objeto salvo.
- **GET** /api/v1/employee/cellphone: Buscar um funcionário pelo seu celular, e retorna seu objeto salvo.
- **POST** /api/v1/employee/inactivate: Inativa um funcionário, tornando seu status de 'A' para 'I'.


  
