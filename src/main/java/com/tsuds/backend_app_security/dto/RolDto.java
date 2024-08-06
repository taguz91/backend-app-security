

package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Rol;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RolDto {

    @NotBlank(message = "El nombre del rol es obligatorio")
    private String rol;

    @NotNull(message = "El estado del rol es obligatorio")
    private boolean estado;

    public Rol toRol() {
        return new Rol()
                .setRol(rol)
                .setEstado(estado);
    }

}
