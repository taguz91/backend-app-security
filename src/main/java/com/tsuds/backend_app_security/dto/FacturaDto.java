
package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Factura;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FacturaDto {

    @NotBlank(message = "la persona es requerido para crear la factura")
    private int idPersona;

    @NotBlank(message = "El tipo de pago  es requerido para crear la factura")
    private int idTipoPago;

    @NotBlank(message = "El ruc es requerido para crear la factura")
    private String ruc;

    @NotBlank(message = "el descuento es requerido para crear la factura")
    private double descuento;

    @NotNull(message = "Se debe por lo menos enviar un item a facturar")
    private List<ItemFacturaDto> items;

    public Factura toFactura() {
        double total = items.stream().mapToDouble(ItemFacturaDto::getPrecio).sum();

        return new Factura()
                .setRuc(ruc)
                .setDescuento(descuento)
                .setTotal(total)
                .setFecha(new Date());
    }
}
