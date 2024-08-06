package com.tsuds.backend_app_security.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Rol")
@Accessors(chain = true)
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    private String rol;
    private boolean estado;

    @ManyToMany
    Set<Competencia> competencias;

    @ManyToMany
    Set<Usuario> usuarios;

    // Getters y Setters
}
