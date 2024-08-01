package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.dto.UsuarioDto;
import com.tsuds.backend_app_security.models.Usuario;
import com.tsuds.backend_app_security.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("")
    public List<Usuario> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public Usuario create(@Valid @RequestBody UsuarioDto user) {
        return repository.save(user.toUsuario());
    }
}
