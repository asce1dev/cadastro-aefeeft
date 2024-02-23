package com.asce1dev.cadastroaefeeft.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Endereco {

	@Column(name = "rua_endereco")
	private String rua;
	
	@Column(name = "numero_endereco")
	private String numero;
	
	@Column(name = "bairro_endereco")
	private String bairro;
	
	@Column(name = "cep_endereco")
	private String cep;
	
	@Column(name = "cidade_endereco")
	private String cidade;
	
	@Column(name = "estado_endereco")
	private String estado;

}
