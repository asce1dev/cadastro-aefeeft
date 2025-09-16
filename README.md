# Cadastro AEFEEFT

## Descrição do Projeto

API REST para cadastro, busca e exclusão de clientes da Associação.

## Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- AWS RDS (Opcional)

# Configurações do Hibernate (em fase de desenvolvimento)
spring.jpa.hibernate.ddl-auto=update

# Configurações do JPA
spring.jpa.show-sql=true

# Funcionalidades

#### Listar Todos os Aposentados ou Pensionistas

- **Método:** GET
- **Endpoint:** `/clientes`
- **Status esperados:** 200 OK - Lista retornada com sucesso.
                        204 No Content - Nenhum cliente encontrado. 
- **Descrição:** Retorna uma lista de todos os clientes cadastrados.

#### Obter Aposentado ou Pensionista por ID

- **Método:** GET
- **Endpoint:** `/clientes/{id}`
- **Status esperados:** 200 OK - Cliente encontrado e retornado com sucesso.
                        404 Not Found - Cliente não encontrado.
- **Descrição:** Obtém informações detalhadas de um aposentado ou pensionista específico com base no ID fornecido.

#### Buscar Aposentado ou Pensionista por Nome

- **Método:** GET
- **Endpoint:** `/clientes/por-nome/{nome}`
- **Status esperados:** 200 OK - Lista de clientes retornada.
                        204 No Content - Nenhum cliente encontrado.
- **Descrição:** Retorna uma lista de clientes que possuem o nome fornecido.

#### Buscar Aposentado ou Pensionista por CPF

- **Método:** GET
- **Endpoint:** `/clientes/por-cpf/{cpf}`
- **Status esperados:** 200 OK - Cliente(s) encontrado(s).
                        400 Bad Request - CPF inválido ou mal formatado.
                        404 Not Found - Nenhum cliente encontrado.
- **Descrição:** Retorna um cliente específico ou uma lista de clientes, caso o CPF informado não esteja completo.

#### Cadastrar ou Atualizar Aposentado/Pensionista

- **Método:** POST
- **Endpoint:** `/clientes`
- **Atributos Obrigatórios:** `nome`, `cpf`, `email`
- **Status esperados:** 201 Created - Cliente cadastrado com sucesso.
                        200 OK - Cliente atualizado com sucesso.
                        400 Bad Request - Dados inválidos ou faltando campos obrigatórios.
                        409 Conflict - CPF ou email já cadastrados.
- **Descrição:** Cadastra um novo cliente ou atualiza as informações de um cliente existente.

#### Deletar Aposentado ou Pensionista por ID

- **Método:** DELETE
- **Endpoint:** `/clientes/{id}`
- **Descrição:** Exclui um cliente específico com base no ID fornecido.



