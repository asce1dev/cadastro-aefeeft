package com.asce1dev.cadastroaefeeft.domain.service;

import com.asce1dev.cadastroaefeeft.domain.exception.EntidadeNaoEncontradaException;
import com.asce1dev.cadastroaefeeft.domain.exception.NegocioException;
import com.asce1dev.cadastroaefeeft.domain.exception.UsuarioNaoEncontradoException;
import com.asce1dev.cadastroaefeeft.domain.model.Role;
import com.asce1dev.cadastroaefeeft.domain.model.Usuario;
import com.asce1dev.cadastroaefeeft.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        try {
            if(usuario.getRole() == null) {
                usuario.setRole(Role.USER);
            }

            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

            return usuarioRepository.saveAndFlush(usuario);
        } catch (DataIntegrityViolationException e) {
            throw new NegocioException("Username já está em uso");
        }
    }

    @Transactional
    public void alterarSenha(Long usuarioId, String novaSenha) {
        var usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));

        usuario.setPassword(passwordEncoder.encode(novaSenha));
        usuarioRepository.saveAndFlush(usuario);

    }

}
