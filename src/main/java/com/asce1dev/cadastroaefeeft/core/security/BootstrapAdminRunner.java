package com.asce1dev.cadastroaefeeft.core.security;

import com.asce1dev.cadastroaefeeft.domain.model.Role;
import com.asce1dev.cadastroaefeeft.domain.model.Usuario;
import com.asce1dev.cadastroaefeeft.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BootstrapAdminRunner implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.security.bootstrap-admin.username:}")
    private String username;

    @Value("${app.security.bootstrap-admin.password:}")
    private String password;

    @Override
    public void run(String... args) {
        if (username == null || username.isBlank()
                || password == null || password.isBlank()) {
            log.info("Bootstrap admin não configurado. Nenhuma ação executada.");
            return;
        }

        if (usuarioRepository.existsByRole(Role.ADMIN)) {
            log.info("Bootstrap admin já existe. Nenhuma ação executada.");
            return;
        }

        var admin = new Usuario();
        admin.setUsername(username);
        admin.setPassword(passwordEncoder.encode(password));
        admin.setRole(Role.ADMIN);
        admin.setActive(true);

        usuarioRepository.save(admin);

        log.info("Bootstrap admin criado com sucesso.");
    }
}
