
package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.dto.ProductoDto;
import com.tsuds.backend_app_security.models.Producto;
import com.tsuds.backend_app_security.models.pojo.Message;
import com.tsuds.backend_app_security.repository.ProductoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Producto")
public class ProductoController {

    @Autowired
    private ProductoRepository repository;

    @GetMapping("")
    public List<Producto> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public Producto create(@Valid @RequestBody ProductoDto Producto) {
        return repository.save(Producto.toProducto());
    }

    @PutMapping("/{id}")
    public Producto update(
            @Valid @RequestBody ProductoDto productoDto,
            @PathVariable Integer id
    ) {
        Producto producto = productodto.toProducto();
        producto.setIdProducto(id);

        return repository.save(producto);
    }

    @DeleteMapping("/{id}")
    public Message delete(
            @PathVariable Integer id
    ) {
        repository.deleteById(id);

        return new Message("Eliminamos correctamente el producto");
    }
}
