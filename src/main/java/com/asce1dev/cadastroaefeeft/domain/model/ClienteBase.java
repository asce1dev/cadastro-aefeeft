package com.asce1dev.cadastroaefeeft.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class ClienteBase {
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cpf;
	
//	@Column(nullable = false)
	private String email;
	
//	@Column(nullable = false)
	private String senhaGov;
	
	private String matriculaSiape;
	private String telefone;
	private String contaCorrente;
	private String dataNascimento;
	private String nomePai;
	private String nomeMae;
	private String tituloEleitor;
	private String categoria;
	
	private EstadoCivil estadoCivil;
	
	
}
