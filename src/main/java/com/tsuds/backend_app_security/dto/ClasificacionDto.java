package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Clasificacion;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClasificacionDto {

    @NotBlank(message = "El grupo es requerido para crear la clasificacion")
    private String grupo;

    public Clasificacion toClasificacion() {
        return new Clasificacion()
                .setGrupo(grupo);
    }
}
