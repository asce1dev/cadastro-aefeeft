package com.asce1dev.cadastroaefeeft.api.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteAposentadoResumoModel {

	private Long id;
	private String nome;
	private String cpf;
	private LocalDateTime dataCadastro;
	
}
