package com.asce1dev.cadastroaefeeft.domain.model;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Column(unique = true)
	private String cpf;
	
	@NotBlank
	private String senhaGov;

	@Email
	@NotBlank
	private String email;
	
	private String telefone;
	private String tituloEleitor;
	private String dataNascimento;
	private String matriculaSiape;
	private String contaCorrente;
	private String nomePai;
	private String nomeMae;
	private String classe;
	private String padrao;
	private String identificacaoUnica;

	@NotBlank
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	@CreationTimestamp
	@Column(columnDefinition = "dateTime")
	private OffsetDateTime dataCadastro;
	
	@UpdateTimestamp
	@Column(columnDefinition = "dateTime")
	private OffsetDateTime dataAtualizacao;
	
	@Embedded
	private Endereco endereco;
	
}
