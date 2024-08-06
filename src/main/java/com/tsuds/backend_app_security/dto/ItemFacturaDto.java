
package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Factura;
import com.tsuds.backend_app_security.models.ItemFactura;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ItemFacturaDto {

    @NotBlank(message = "El identificador del producto es requerido para crear la factura")
    private int idProducto;

    @NotBlank(message = "la cantidad de uvas es requerido para crear la factura")
    private int cantidad;

    @NotBlank(message = "El precio de la factura es requerido para crear la factura")
    private double precio;

    public ItemFactura toItemFactura(Factura factura) {
        return new ItemFactura()
                .setFactura(factura)
                .setCantidad(cantidad)
                .setPrecio(precio)
                .setSubtotal(precio * cantidad);
    }

    public double getTotal()
    {
        return precio * cantidad;
    }

}
