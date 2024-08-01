package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.dto.ClasificacionDto;
import com.tsuds.backend_app_security.models.Clasificacion;
import com.tsuds.backend_app_security.models.pojo.Message;
import com.tsuds.backend_app_security.repository.ClasificacionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clasificacion")
public class ClasificacionController {

    @Autowired
    private ClasificacionRepository repository;

    @GetMapping("")
    public List<Clasificacion> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public Clasificacion create(@Valid @RequestBody ClasificacionDto clasificacion) {
        return repository.save(clasificacion.toClasificacion());
    }

    @PutMapping("/{id}")
    public Clasificacion update(
            @Valid @RequestBody ClasificacionDto clasificacionDto,
            @PathVariable Integer id
    ) {
        Clasificacion clasificacion = clasificacionDto.toClasificacion();
        clasificacion.setIdClasificacion(id);

        return repository.save(clasificacion);
    }

    @DeleteMapping("/{id}")
    public Message delete(
            @PathVariable Integer id
    ) {
        repository.deleteById(id);

        return new Message("Eliminamos correctamente la clasificacion");
    }
}
