package com.tsuds.backend_app_security.dto;

import jakarta.validation.constraints.NotBlank;

public class ClasificacionDto {

    @NotBlank(message = "El grupo es requerido para crear la clasificacion")
    private String grupo;
}
