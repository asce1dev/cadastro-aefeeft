create table cliente_aposentado (
	id bigint not null auto_increment,
    nome varchar(80) not null,
    cpf varchar(11) not null,
    senha_gov varchar(60),
    email varchar(60),
    telefone varchar(30), 
    titulo_eleitor varchar(25),
    data_nascimento varchar(8), 
	estado_civil varchar(25), 
    conta_corrente varchar(25), 
	nome_mae varchar(60), 
    nome_pai varchar(60),
    rua_endereco varchar(25),
    numero_endereco varchar(25),
    bairro_endereco varchar(25), 
    cidade_endereco varchar(25),
    cep_endereco varchar(10), 
    estado_endereco varchar(25),
    categoria varchar(25), 
    identificacao_unica varchar(25), 
    padrao varchar(60),
    matricula_siape varchar(25), 
    classe varchar(25),
    data_atualizacao dateTime, 
    data_cadastro dateTime,
	
    primary key (id)
) engine=InnoDB default charset=utf8;

create table cliente_pensionista (
	id bigint not null auto_increment,
    nome varchar(80) not null,
    cpf varchar(11) not null,
    senha_gov varchar(60),
    email varchar(60),
    telefone varchar(30), 
    categoria varchar(25),
    titulo_eleitor varchar(25),
    data_nascimento varchar(8), 
	estado_civil varchar(25), 
    conta_corrente varchar(25), 
	nome_mae varchar(60), 
    nome_pai varchar(60),
    rua_endereco varchar(25),
    numero_endereco varchar(25),
    bairro_endereco varchar(25), 
    cidade_endereco varchar(25),
    cep_endereco varchar(10), 
    estado_endereco varchar(25),
    matricula_siape varchar(25), 
    data_atualizacao dateTime, 
    data_cadastro dateTime,

    primary key (id)
) engine=InnoDB default charset=utf8;