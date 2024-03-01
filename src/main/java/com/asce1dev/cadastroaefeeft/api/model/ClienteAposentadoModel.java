package com.asce1dev.cadastroaefeeft.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteAposentadoModel {

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String senhaGov;
	private String matriculaSiape;
	private String telefone;
	private String contaCorrente;
	private String dataNascimento;
	private String nomePai;
	private String nomeMae;
	private String tituloEleitor;
	private String estadoCivil;
	private String categoria;
	private String classe;
	private String padrao;
	private String identificacaoUnica;
	private EnderecoModel endereco;
	private OffsetDateTime dataCadastro;
	private OffsetDateTime dataAtualizacao;

	
}
