

package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProveedoresDto {

    @NotBlank(message = "El nombre el proveedor es obligatorio")
    private String nombre;
  @NotBlank(message = "El ruc el proveedor es obligatorio")
    private String ruc;
  @NotBlank(message = "El relefono de contacto del proveedor es obligatorio")
    private String telefono;
  @NotBlank(message = "El pais de recidencia del proveedor es obligatorio")
    private String pais;
  
    }
}
