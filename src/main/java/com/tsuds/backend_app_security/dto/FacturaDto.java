
package com.tsuds.backend_app_security.dto;

import jakarta.validation.constraints.NotBlank;

public class FacturaDto {

    @NotBlank(message = "El ruc es requerido para crear la factura")
      private String ruc;

 @NotBlank(message = "la persona es requerido para crear la factura")
    private int idPersona;
  
 @NotBlank(message = "la recha es requerida crear la factura")
    private Date fecha;

    @NotBlank(message = "El tipo de pago  es requerido para crear la factura")
    private int idTipoPago;
  
 @NotBlank(message = "el descuento es requerido para crear la factura")
    private double descuento;
  
   @NotBlank(message = "El total es requerido para crear la factura")
    private double total;

}
