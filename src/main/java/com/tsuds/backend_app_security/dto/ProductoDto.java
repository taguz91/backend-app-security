

package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Producto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductoDto {

    @NotNull(message = "El stock del producto es obligatorio")
    private int stock;

    @NotNull(message = "El precion unitario del producto es obligatorio")
    private double precioUnitario;

    @NotBlank(message = "las unidades del producto es obligatorio")
    private String unidad;
  
    @NotNull(message = "la clasificacion del producto es obligatorio")
    private int idClasificacion;

    @NotNull(message = "El proveedor del producto es obligatorio")
    private int idProveedor;

    @NotNull(message = "El iva que controla el producto es obligatorio")
    private boolean iva;

    public Producto toProducto() {
        return new Producto()
                .setStock(stock)
                .setPrecioUnitario(precioUnitario)
                .setUnidad(unidad)
                .setIva(iva);
        
    }
}
