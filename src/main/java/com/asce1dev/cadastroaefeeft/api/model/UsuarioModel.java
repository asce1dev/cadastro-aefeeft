package com.asce1dev.cadastroaefeeft.api.model;

import com.asce1dev.cadastroaefeeft.domain.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioModel {

    private Long id;
    private String username;
    private Role role;
    private boolean active;
}
