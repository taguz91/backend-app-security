package com.tsuds.backend_app_security.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;

    private String ruc;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago", nullable = false)
    private TipoPago tipoPago;

    private double descuento;
    private double total;

    @OneToMany(mappedBy = "factura")
    private List<ItemFactura> items;

    // Getters y Setters
}
