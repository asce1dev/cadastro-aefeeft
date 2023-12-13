package com.asce1dev.cadastroaefeeft.api.controller.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso Não Encontrado."),
	ERRO_NEGOCIO("/erro-negocio", "Erro de Negocio"),
	ENTIDADE_EM_USO("/entidade-em-uso","Entidade em uso");
	
	private String uri;
	private String title;
	
	ProblemType(String title, String path) {
		this.uri = "https://aefeeft.com.br" + path;
		this.title = title;
	}
	
	
}
