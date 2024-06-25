package com.asce1dev.cadastroaefeeft.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResumoModel {

	private Long id;
	private String nome;
	private String cpf;
	private OffsetDateTime dataCadastro;
	
}
