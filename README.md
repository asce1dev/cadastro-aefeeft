# Cadastro AEFEEFT – API

API REST desenvolvida com **Spring Boot** para gerenciamento de cadastros de clientes.

## Tecnologias
- Java
- Spring Boot
- Spring Data JPA
- Bean Validation
- Lombok
- Maven

## Funcionalidades
- CRUD de clientes
- Listagem paginada e ordenada
- Filtros por nome ou CPF
- Tratamento padronizado de erros (REST)
- Validações de entrada

## Padrões adotados
- Endpoint único para listagem com filtros
- DTOs + Assemblers
- Camada de Service com regras de negócio
- Injeção por construtor
- Exception Handler centralizado

## Execução
```bash
mvn spring-boot:run
