

package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductoDto {

    @NotBlank(message = "El stock del producto es obligatorio")
    private int stock;
    @NotBlank(message = "El precion unitario del producto es obligatorio")
    private double precioUnitario;

    @NotBlank(message = "las unidades del producto es obligatorio")
    private String unidad;
  
    @NotBlank(message = "la clasificacion del producto es obligatorio")
    private int idClasificacion;

    @NotBlank(message = "El proveedor del producto es obligatorio")
    private Proveedores proveedor;

    @NotBlank(message = "El iva que controla el producto es obligatorio")
    private boolean iva;

    public Producto toProducto() {
        return new Producto()
                .setStock(stock);
                .setPrecioUnitario(precioUnitario);
                .setUnidad(unidad);
                .setIdClasificacion(idClasificacion);
                .setIva(iva);
        
    }
}
