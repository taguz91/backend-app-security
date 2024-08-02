package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.dto.ProveedoresDto;
import com.tsuds.backend_app_security.models.Proveedores;
import com.tsuds.backend_app_security.models.pojo.Message;
import com.tsuds.backend_app_security.repository.ProveedoresRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedoresRepository repository;

    @GetMapping("")
    public List<Proveedores> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public Proveedores create(@Valid @RequestBody ProveedoresDto proveedoresDto) {
        return repository.save(proveedoresDto.toProveedor());
    }

    @PutMapping("/{id}")
    public Proveedores update(
            @Valid @RequestBody ProveedoresDto proveedoresDto,
            @PathVariable Integer id
    ) {
        Proveedores proveedor = proveedoresDto.toProveedor();
        proveedor.setIdProveedor(id);

        return repository.save(proveedor);
    }

    @DeleteMapping("/{id}")
    public Message delete(
            @PathVariable Integer id
    ) {
        repository.deleteById(id);

        return new Message("Eliminamos correctamente el proveedor");
    }
}
