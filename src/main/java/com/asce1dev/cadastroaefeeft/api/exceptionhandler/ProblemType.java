package com.asce1dev.cadastroaefeeft.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
	ERRO_DE_SISTEMA("/erro-de-sistema","Erro de Sistema"),
	PARAMETRO_INVALIDO("/parametro-invaldo", "Parâmetro Inválido"), 
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel","Mensagem Incompreesível"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso Não Encontrado."),
	ENTIDADE_EM_USO("/entidade-em-uso","Entidade em uso"), 
	ERRO_NEGOCIO("/erro-negocio", "Erro de Negocio");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "https://aefeeft.com.br" + path;
		this.title = title;
	}
	
	
}
