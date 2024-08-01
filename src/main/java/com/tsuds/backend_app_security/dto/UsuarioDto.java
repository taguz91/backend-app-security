package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioDto {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String username;

    @NotBlank(message = "La password es requerida")
    private String password;

    public Usuario toUsuario() {
        return new Usuario()
                .setUser(username)
                .setPassword(password);
    }
}
