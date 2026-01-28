package com.asce1dev.cadastroaefeeft.api.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import com.asce1dev.cadastroaefeeft.domain.model.Categoria;
import com.asce1dev.cadastroaefeeft.domain.model.EstadoCivil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteModel {

	private Long id;
	private String nome;
	private String cpf;
	private String email;
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
	private OffsetDateTime dataCadastro;
	private OffsetDateTime dataAtualizacao;

	private Categoria categoria;
	private EstadoCivil estadoCivil;
	private EnderecoModel endereco;
}
