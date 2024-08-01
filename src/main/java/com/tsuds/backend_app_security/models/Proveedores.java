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
@Table(name = "Proveedores")
@Accessors(chain = true)
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;

    private String nombre;
    private String ruc;
    private String telefono;
    private String pais;

    // Getters y Setters
}
