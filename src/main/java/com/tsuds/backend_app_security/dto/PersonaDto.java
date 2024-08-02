
package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.Persona;
import com.tsuds.backend_app_security.models.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PersonaDto {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido de usuario es obligatorio")
    private String apellido;

    @NotBlank(message = "El dni de usuario es obligatorio")
    private String dni;

    @NotBlank(message = "El celular de usuario es obligatorio")
    private String celular;

    @NotBlank(message = "El correo electronico de usuario es obligatorio")
    private String correo;

    public Persona toPersona() {
        return new Persona()
                .setNombre(nombre)
                .setApellido(apellido)
                .setDni(dni)
                .setCelular(celular)
                .setCorreo(correo);
    }
}
