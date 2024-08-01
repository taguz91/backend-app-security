package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Competencia;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompetenciaDto {

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "la descripcion es requerida")
    private String descripcion;

    public Competencia toCompetencia() {
        return new Competencia()
                .setNombre(nombre)
                .setDescripcion(descripcion);
    }
}
