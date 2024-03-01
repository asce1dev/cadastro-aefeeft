package com.asce1dev.cadastroaefeeft.domain.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
	
	@Embedded
	private Endereco endereco;
	
}
