package com.asce1dev.cadastroaefeeft.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoModel {

	private String rua;
	private String numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
}
