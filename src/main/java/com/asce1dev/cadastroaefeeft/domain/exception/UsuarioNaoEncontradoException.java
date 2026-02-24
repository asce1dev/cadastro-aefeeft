package com.asce1dev.cadastroaefeeft.domain.exception;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

    public UsuarioNaoEncontradoException(Long id) {
        super(String.format("Usuário de código %d não foi encontrado", id));
    }

    public UsuarioNaoEncontradoException(String username) {
        super(String.format("Usuário '%s' não foi encontrado", username));
    }
}
