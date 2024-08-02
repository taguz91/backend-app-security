
package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.dto.ProductoDto;
import com.tsuds.backend_app_security.models.Clasificacion;
import com.tsuds.backend_app_security.models.Producto;
import com.tsuds.backend_app_security.models.Proveedores;
import com.tsuds.backend_app_security.models.pojo.Message;
import com.tsuds.backend_app_security.repository.ClasificacionRepository;
import com.tsuds.backend_app_security.repository.ProductoRepository;
import com.tsuds.backend_app_security.repository.ProveedoresRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository repository;
    @Autowired
    private ProveedoresRepository proveedoresRepository;
    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @GetMapping("")
    public List<Producto> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public Producto create(@Valid @RequestBody ProductoDto producto) {
        return repository.save(nestedObjects(producto));
    }

    @PutMapping("/{id}")
    public Producto update(
            @Valid @RequestBody ProductoDto productoDto,
            @PathVariable Integer id
    ) {
        Producto producto = nestedObjects(productoDto);
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

    private Producto nestedObjects(ProductoDto productoDto) {
        Optional<Proveedores> proveedores = proveedoresRepository.findById(productoDto.getIdProveedor());

        if (proveedores.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El proveedor no existe"
            );
        }

        Optional<Clasificacion> clasificacion = clasificacionRepository.findById(productoDto.getIdClasificacion());

        if (clasificacion.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "La clasificacion no existe"
            );
        }

        Producto producto = productoDto.toProducto();

        producto.setProveedor(proveedores.get());
        producto.setClasificacion(clasificacion.get());

        return producto;
    }
}
