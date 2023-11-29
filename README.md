# Cadastro AEFEEFT

## Descrição do Projeto

Sistema para facilitar o cadastro, busca e exclusão de clientes da Associação.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- AWS RDS

## Instruções de Instalação

1. Utilize o Java 17.
2. Utilize a última versão estável do Spring Tool Suite no Eclipse.
3. Faça o download e instale o Lombok no Spring Tool Suite.
4. Utilize o MySQL e MySQL Workbench para visualizar as tabelas no banco de dados.
5. Configure o arquivo `application.properties` com as informações do seu banco de dados:

```properties
spring.datasource.url=jdbc:mysql://url-do-banco-de-dados/nome-do-banco-de-dados?serverTimezone=UTC
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
```

# Configurações do Hibernate
spring.jpa.hibernate.ddl-auto=update

# Configurações do JPA
spring.jpa.show-sql=true

# Funcionalidades

#### Listar Todos os Aposentados ou Pensionistas

- **Método:** GET
- **Endpoint:** `/aposentados` ou `/pensionistas`
- **Descrição:** Retorna uma lista de todos os clientes cadastrados.

#### Obter Aposentado ou Pensionista por ID

- **Método:** GET
- **Endpoint:** `/aposentados/{id}` ou `/pensionistas/{id}`
- **Descrição:** Obtém informações detalhadas de um aposentado ou pensionista específico com base no ID fornecido.

#### Cadastrar ou Atualizar Aposentado/Pensionista

- **Método:** POST
- **Endpoint:** `/aposentados` ou `/pensionistas`
- **Requisitos Mínimos:** `nome`, `cpf`, `email`
- **Descrição:** Cadastra um novo cliente ou atualiza as informações de um cliente existente.

#### Deletar Aposentado ou Pensionista por ID

- **Método:** DELETE
- **Endpoint:** `/aposentados/{id}` ou `/pensionistas/{id}`
- **Descrição:** Exclui um cliente específico com base no ID fornecido.

#### Buscar Aposentado ou Pensionista por Nome

- **Método:** GET
- **Endpoint:** `/aposentados/por-nome/{nome}` ou `/pensionistas/por-nome/{nome}`
- **Descrição:** Retorna uma lista de clientes que possuem o nome fornecido.

#### Buscar Aposentado ou Pensionista por CPF

- **Método:** GET
- **Endpoint:** `/aposentados/por-cpf/{cpf}` ou `/pensionistas/por-cpf/{cpf}`
- **Descrição:** Retorna uma lista de aposentados que possuem o CPF fornecido.
