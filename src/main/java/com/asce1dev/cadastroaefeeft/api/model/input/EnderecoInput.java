package com.asce1dev.cadastroaefeeft.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {

	private String rua;
	private String numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	
}
