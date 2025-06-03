package com.example.demo.Controller;

import com.example.demo.Model.ProductoCiudad;
import com.example.demo.Service.ProductoCiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos-ciudad")
public class ProductoCiudadController {

    @Autowired
    private ProductoCiudadService productoCiudadService;

    @GetMapping
    public ResponseEntity<List<ProductoCiudad>> getAll() {
        List<ProductoCiudad> lista = productoCiudadService.getAllProductoCiudad();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoCiudad> getById(@PathVariable Long id) {
        return productoCiudadService.getProductoCiudadById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductoCiudad> create(@RequestBody ProductoCiudad productoCiudad) {
        ProductoCiudad creado = productoCiudadService.createProductoCiudad(productoCiudad);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoCiudad> update(@PathVariable Long id, @RequestBody ProductoCiudad productoCiudad) {
        try {
            ProductoCiudad actualizado = productoCiudadService.updateProductoCiudad(id, productoCiudad);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoCiudadService.deleteProductoCiudad(id);
        return ResponseEntity.noContent().build();
    }
}
