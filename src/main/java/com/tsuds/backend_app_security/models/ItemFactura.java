package com.tsuds.backend_app_security.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Item_Factura")
@Accessors(chain = true)
public class ItemFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItemFactura;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
    @JsonIgnore
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    private int cantidad;
    private double precio;
    private double subtotal;

    // Getters y Setters
}
