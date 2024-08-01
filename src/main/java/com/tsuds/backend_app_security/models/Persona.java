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
@Table(name = "Persona")
@Accessors(chain = true)
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;

    private String nombre;
    private String apellido;
    private String dni;
    private String celular;
    private String correo;

    // Getters y Setters

    public String getNombreCompleto() {
        return nombre + ' ' + apellido;
    }
}
