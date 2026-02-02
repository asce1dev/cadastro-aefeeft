package com.asce1dev.cadastroaefeeft.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class ClienteResumoModel {

	private Long id;
	private String nome;
	private String cpf;
	private OffsetDateTime dataCadastro;
	
}
