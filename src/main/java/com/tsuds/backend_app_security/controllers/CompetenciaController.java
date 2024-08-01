package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.dto.ClasificacionDto;
import com.tsuds.backend_app_security.dto.CompetenciaDto;
import com.tsuds.backend_app_security.models.Clasificacion;
import com.tsuds.backend_app_security.models.Competencia;
import com.tsuds.backend_app_security.models.pojo.Message;
import com.tsuds.backend_app_security.repository.ClasificacionRepository;
import com.tsuds.backend_app_security.repository.CompetenciaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/competencia")
public class CompetenciaController {
    @Autowired
    private CompetenciaRepository repository;

    @GetMapping("")
    public List<Competencia> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public Competencia create(@Valid @RequestBody CompetenciaDto competenciaDto) {
        return repository.save(competenciaDto.toCompetencia());
    }

    @PutMapping("/{id}")
    public Competencia update(
            @Valid @RequestBody CompetenciaDto competenciaDto,
            @PathVariable Integer id
    ) {
        Competencia competencia = competenciaDto.toCompetencia();
        competencia.setIdCompetencias(id);

        return repository.save(competencia);
    }

    @DeleteMapping("/{id}")
    public Message delete(
            @PathVariable Integer id
    ) {
        repository.deleteById(id);

        return new Message("Eliminamos correctamente la clasificacion");
    }
}
