package com.tsuds.backend_app_security.dto;

import jakarta.validation.constraints.NotBlank;

public class CompetenciaDto {

    @NotBlank(message = "El nombre es requerido")
  private String nombre;
  @NotBlank(message = "la descripcion es requerida")
    private String descripcion;

}
