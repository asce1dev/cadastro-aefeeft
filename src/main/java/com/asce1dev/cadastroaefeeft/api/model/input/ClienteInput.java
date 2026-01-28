package com.asce1dev.cadastroaefeeft.api.model.input;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.asce1dev.cadastroaefeeft.domain.model.Categoria;
import com.asce1dev.cadastroaefeeft.domain.model.EstadoCivil;
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
	private String email;

	private String senhaGov;
	
	private String matriculaSiape;
	private String telefone;
	private String contaCorrente;
	private LocalDate dataNascimento;
	private String nomePai;
	private String nomeMae;
	private String tituloEleitor;
	private String classe;
	private String padrao;
	private String identificacaoUnica;

	@NotNull
	private EstadoCivil estadoCivil;

	@NotNull
	private Categoria categoria;

	@Valid
	@NotNull
	private EnderecoInput endereco;
	
}
