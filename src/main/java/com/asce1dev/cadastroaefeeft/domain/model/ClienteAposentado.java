package com.asce1dev.cadastroaefeeft.domain.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ClienteAposentado extends ClienteBase {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String classe;
	private String padrao;
	private String identificacaoUnica;
	
	@JsonIgnore
	@Embedded
	private Endereco endereco;
	
	@Enumerated
	private EstadoCivil estadoCivil;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(columnDefinition = "dateTime")
	private LocalDateTime dataCadastro;
	
	@JsonIgnore
	@UpdateTimestamp
	@Column(columnDefinition = "dateTime")
	private LocalDateTime dataAtualizacao;
	
}
