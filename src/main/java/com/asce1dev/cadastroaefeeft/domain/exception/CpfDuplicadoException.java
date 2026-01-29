package com.asce1dev.cadastroaefeeft.domain.exception;

public class CpfDuplicadoException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public CpfDuplicadoException() {
        super("Já existe um cliente cadastrado com este CPF.");
    }

}
