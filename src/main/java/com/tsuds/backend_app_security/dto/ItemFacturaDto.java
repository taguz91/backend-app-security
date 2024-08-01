
package com.tsuds.backend_app_security.dto;

import jakarta.validation.constraints.NotBlank;

public class FacturaDto {

    @NotBlank(message = "El item de la factura es requerido para crear la factura")
 private int ItemFacturaDto;

    @NotBlank(message = "el identificador de la factura es requerido para credar la factura")
    private int IdFactura;

    @NotBlank(message = "El identificador del producto es requerido para crear la factura")
    private Producto IdProducto;
  
    @NotBlank(message = "la cantidad de uvas es requerido para crear la factura")
    private int cantidad;
  
      @NotBlank(message = "El precio de la factura es requerido para crear la factura")
    private double precio;
  
      @NotBlank(message = "El subtotanl de la factura es requerido para crear la factura")
    private double subtotal;

}
