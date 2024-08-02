package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.dto.FacturaDto;
import com.tsuds.backend_app_security.models.Factura;
import com.tsuds.backend_app_security.models.Persona;
import com.tsuds.backend_app_security.models.TipoPago;
import com.tsuds.backend_app_security.models.pojo.Message;
import com.tsuds.backend_app_security.repository.FacturaRepository;
import com.tsuds.backend_app_security.repository.PersonaRepository;
import com.tsuds.backend_app_security.repository.TipoPagoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/factura")
public class FacturaController {

    @Autowired
    private FacturaRepository repository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private TipoPagoRepository tipoPagoRepository;

    @GetMapping("")
    public List<Factura> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public Factura create(@Valid @RequestBody FacturaDto factura) {
        return repository.save(addNestedObjects(factura));
    }

    @PutMapping("/{id}")
    public Factura update(
            @Valid @RequestBody FacturaDto facturaDto,
            @PathVariable Integer id
    ) {
        Factura factura = addNestedObjects(facturaDto);
        factura.setIdFactura(id);

        return repository.save(factura);
    }

    @DeleteMapping("/{id}")
    public Message delete(
            @PathVariable Integer id
    ) {
        repository.deleteById(id);

        return new Message("Eliminamos correctamente la factura");
    }

    private Factura addNestedObjects(FacturaDto facturaDto) {
        Optional<Persona> persona = personaRepository.findById(facturaDto.getIdPersona());

        if (persona.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "La persona no existe"
            );
        }

        Optional<TipoPago> tipoPago = tipoPagoRepository.findById(facturaDto.getIdTipoPago());

        if (tipoPago.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El tipo de pago no existe"
            );
        }

        Factura factura = facturaDto.toFactura();
        factura.setPersona(persona.get());
        factura.setTipoPago(tipoPago.get());

        return factura;
    }
}
