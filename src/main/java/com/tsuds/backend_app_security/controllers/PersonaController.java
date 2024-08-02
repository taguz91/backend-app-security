package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.dto.PersonaDto;
import com.tsuds.backend_app_security.models.Persona;
import com.tsuds.backend_app_security.models.pojo.Message;
import com.tsuds.backend_app_security.repository.PersonaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class PersonaController {

    @Autowired
    private PersonaRepository repository;

    @GetMapping("")
    public List<Persona> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public Persona create(@Valid @RequestBody PersonaDto personaDto) {
        return repository.save(personaDto.toPersona());
    }

    @PutMapping("/{id}")
    public Persona update(
            @Valid @RequestBody PersonaDto personaDto,
            @PathVariable Integer id
    ) {
        Persona persona = personaDto.toPersona();
        persona.setIdPersona(id);

        return repository.save(persona);
    }

    @DeleteMapping("/{id}")
    public Message delete(
            @PathVariable Integer id
    ) {
        repository.deleteById(id);

        return new Message("Eliminamos correctamente la persona");
    }
}
