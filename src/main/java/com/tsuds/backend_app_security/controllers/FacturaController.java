package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.dto.CompetenciaDto;
import com.tsuds.backend_app_security.dto.FacturaDto;
import com.tsuds.backend_app_security.models.Competencia;
import com.tsuds.backend_app_security.models.Factura;
import com.tsuds.backend_app_security.models.Persona;
import com.tsuds.backend_app_security.models.pojo.Message;
import com.tsuds.backend_app_security.repository.CompetenciaRepository;
import com.tsuds.backend_app_security.repository.FacturaRepository;
import com.tsuds.backend_app_security.repository.PersonaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class FacturaController {

    @Autowired
    private FacturaRepository repository;
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("")
    public List<Factura> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public Factura create(@Valid @RequestBody FacturaDto factura) {
        return repository.save(factura.toFactura());
    }

    @PutMapping("/{id}")
    public Factura update(
            @Valid @RequestBody FacturaDto facturaDto,
            @PathVariable Integer id
    ) {
        Factura factura = facturaDto.toFactura();
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
    }
}
