package com.asce1dev.cadastroaefeeft.domain.model;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@MappedSuperclass
@Data
public class ClienteBase {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private String senhaGov;
	
	private String matriculaSiape;
	private String telefone;
	private String contaCorrente;
	private String dataNascimento;
	private String nomePai;
	private String nomeMae;
	private String tituloEleitor;
	private String categoria;
	
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	@CreationTimestamp
	@Column(columnDefinition = "dateTime")
	private OffsetDateTime dataCadastro;
	
	@UpdateTimestamp
	@Column(columnDefinition = "dateTime")
	private OffsetDateTime dataAtualizacao;
	
}
