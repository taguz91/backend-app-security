package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.dto.RolDto;
import com.tsuds.backend_app_security.models.Rol;
import com.tsuds.backend_app_security.models.pojo.Message;
import com.tsuds.backend_app_security.repository.RolRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rol")
public class RolController {

    @Autowired
    private RolRepository repository;

    @GetMapping("")
    public List<Rol> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public Rol create(@Valid @RequestBody RolDto rolDto) {
        return repository.save(rolDto.toRol());
    }

    @PutMapping("/{id}")
    public Rol update(
            @Valid @RequestBody RolDto rolDto,
            @PathVariable Integer id
    ) {
        Rol rol = rolDto.toRol();
        rol.setIdRol(id);

        return repository.save(rol);
    }

    @DeleteMapping("/{id}")
    public Message delete(
            @PathVariable Integer id
    ) {
        repository.deleteById(id);

        return new Message("Eliminamos correctamente el rol");
    }
}
