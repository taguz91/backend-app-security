package com.tsuds.backend_app_security.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Competencia")
@Accessors(chain = true)
public class Competencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompetencias;

    private String nombre;
    private String descripcion;

    // Getters y Setters
}
