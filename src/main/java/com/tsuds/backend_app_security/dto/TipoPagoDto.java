package com.tsuds.backend_app_security.dto;

import com.tsuds.backend_app_security.models.TipoPago;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TipoPagoDto {

    @NotBlank(message = "El tipo de pago es requerido")
    private String tipo;
    @NotBlank(message = "La descripcion de tipo de pago es requerida")
    private String descrip;

    public TipoPago toTipoPago() {
        return new TipoPago()
                .setTipo(tipo)
                .setDescrip(descrip);
    }
}
