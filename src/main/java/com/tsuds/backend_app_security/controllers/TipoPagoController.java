package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.dto.TipoPagoDto;
import com.tsuds.backend_app_security.models.TipoPago;
import com.tsuds.backend_app_security.models.pojo.Message;
import com.tsuds.backend_app_security.repository.TipoPagoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tipo-pago")
public class TipoPagoController {

    @Autowired
    private TipoPagoRepository repository;

    @GetMapping("")
    public List<TipoPago> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public TipoPago create(@Valid @RequestBody TipoPagoDto tipoPagoDto) {
        return repository.save(tipoPagoDto.toTipoPago());
    }

    @PutMapping("/{id}")
    public TipoPago update(
            @Valid @RequestBody TipoPagoDto tipoPagoDto,
            @PathVariable Integer id
    ) {
        TipoPago tipoPago = tipoPagoDto.toTipoPago();
        tipoPago.setIdTipoPago(id);

        return repository.save(tipoPago);
    }

    @DeleteMapping("/{id}")
    public Message delete(
            @PathVariable Integer id
    ) {
        repository.deleteById(id);

        return new Message("Eliminamos correctamente la tipo de pago");
    }
}
