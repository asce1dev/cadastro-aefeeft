delete from cliente;

alter table cliente auto_increment = 1;

insert into cliente (nome, cpf, senha_gov, email, telefone, titulo_eleitor, data_nascimento, estado_civil, conta_corrente, nome_mae, nome_pai, rua_endereco, numero_endereco, bairro_endereco, cidade_endereco, cep_endereco, estado_endereco, categoria, identificacao_unica, padrao, matricula_siape, classe, data_atualizacao, data_cadastro)
values ('Alan Delon', '23410985673', 'Libad@222', 'abc@xyz.com', '74543875694', '12345112', '12/34/5678', 'CASADO', '123123123', 'Adriana', 'Alan 1.0', 'Siqueira Campos', '999', 'Jaqueira', 'Tucumã', '12345678', 'Para, Tira', 'APOSENTADO', '12345678', 'qwerty', '12345678901', 'Arqueiro', utc_timestamp, utc_timestamp);

insert into cliente (nome, cpf, senha_gov, email, telefone, titulo_eleitor, data_nascimento, estado_civil, conta_corrente, nome_mae, nome_pai, rua_endereco, numero_endereco, bairro_endereco, cidade_endereco, cep_endereco, estado_endereco, categoria, identificacao_unica, padrao, matricula_siape, classe, data_atualizacao, data_cadastro)
values ('Gabriel Marçal', '34526789654', 'Ragna@rok1', 'xyz@abc.com', '33432145678', '12345678', '23/45/6789', 'CASADO', '123456789', 'Tia Mae dele', 'Tio James', 'Milagres de Miguel', '777', 'Miguel', 'Sao Miguel dos Milagres', '67854667', 'Alagoas', 'PENSIONISTA', '65476654', 'wasd', '44536785546', 'Lagarto Mago', utc_timestamp, utc_timestamp);

insert into cliente (nome, cpf, senha_gov, email, telefone, titulo_eleitor, data_nascimento, estado_civil, conta_corrente, nome_mae, nome_pai, rua_endereco, numero_endereco, bairro_endereco, cidade_endereco, cep_endereco, estado_endereco, categoria, identificacao_unica, padrao, matricula_siape, classe, data_atualizacao, data_cadastro)
values ('Paulo Vinicius', '43565456546', 'Hero@siege300', 'iniciou@herosiege.com', '12345665432', '34223233', '54/45/6543', 'SOLTEIRO', '998789878', 'Mae', 'Paulo Gyro', 'Avenida Goiania', '666', 'Setor Goiania', 'Goiania', '66545344', 'Goias', 'APOSENTADO', '65477654', 'nprecisa', '55435678564', 'Todas', utc_timestamp, utc_timestamp);
