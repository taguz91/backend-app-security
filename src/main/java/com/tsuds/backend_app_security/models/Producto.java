package com.tsuds.backend_app_security.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    private int stock;
    private double precioUnitario;
    private String unidad;

    @ManyToOne
    @JoinColumn(name = "id_clasificacion", nullable = false)
    private Clasificacion clasificacion;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedores proveedor;

    private boolean iva;

    // Getters y Setters
}
