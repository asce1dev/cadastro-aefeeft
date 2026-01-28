package com.asce1dev.cadastroaefeeft.api.model.input;

import java.time.LocalDateTime;

import com.asce1dev.cadastroaefeeft.domain.model.Categoria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteInput {

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
	private String categoria;
	private String estadoCivil;
	private String classe;
	private String padrao;
	private String identificacaoUnica;
	
	@Valid
	@NotNull
	private EnderecoInput endereco;
	
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;
}
