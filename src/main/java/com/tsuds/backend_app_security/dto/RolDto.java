

package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RolDto {

    @NotBlank(message = "El nombre del rol es obligatorio")
     private String rol;

      @NotBlank(message = "El estado del rol es obligatorio")
    private boolean estado;
  


    }
}
