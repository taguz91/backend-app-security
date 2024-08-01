
package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Factura;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class FacturaDto {

    @NotBlank(message = "El ruc es requerido para crear la factura")
    private String ruc;

    @NotBlank(message = "la persona es requerido para crear la factura")
    private int idPersona;

    @NotBlank(message = "El tipo de pago  es requerido para crear la factura")
    private int idTipoPago;

    @NotBlank(message = "el descuento es requerido para crear la factura")
    private double descuento;

    @NotBlank(message = "El total es requerido para crear la factura")
    private double total;

    public Factura toFactura() {
        return new Factura()
                .setRuc(ruc)
                .setDescuento(descuento)
                .setTotal(total)
                .setFecha(new Date());
    }
}
