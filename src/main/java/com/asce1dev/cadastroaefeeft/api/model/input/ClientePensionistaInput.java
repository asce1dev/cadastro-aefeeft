package com.asce1dev.cadastroaefeeft.api.model.input;

import java.time.OffsetDateTime;

import com.asce1dev.cadastroaefeeft.domain.model.Endereco;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientePensionistaInput {

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
	private String estadoCivil; 
	private String categoria;
	private OffsetDateTime dataCadastro;
	private OffsetDateTime dataAtualizacao;
	
	private Endereco endereco;
	
}
