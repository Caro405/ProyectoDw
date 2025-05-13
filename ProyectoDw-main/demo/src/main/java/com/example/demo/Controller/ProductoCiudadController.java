package com.example.demo.Controller;

import com.example.demo.dto.ProductoCiudadDTO;
import com.example.demo.Service.ProductoCiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productoCiudad")
public class ProductoCiudadController {

    @Autowired
    private ProductoCiudadService productoCiudadService;

    @GetMapping
    public List<ProductoCiudadDTO> getAllProductoCiudad() {
        return productoCiudadService.getAllProductoCiudad();
    }

    @GetMapping("/{id}")
    public ProductoCiudadDTO getProductoCiudadById(@PathVariable Long id) {
        return productoCiudadService.getProductoCiudadById(id)
                .orElseThrow(() -> new RuntimeException("ProductoCiudad no encontrado con ID: " + id));
    }

    @PostMapping
    public ProductoCiudadDTO createProductoCiudad(@RequestBody ProductoCiudadDTO productoCiudadDTO) {
        return productoCiudadService.createProductoCiudad(productoCiudadDTO);
    }

    @PutMapping("/{id}")
    public ProductoCiudadDTO updateProductoCiudad(@PathVariable Long id, @RequestBody ProductoCiudadDTO productoCiudadDTO) {
        return productoCiudadService.updateProductoCiudad(id, productoCiudadDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProductoCiudad(@PathVariable Long id) {
        productoCiudadService.deleteProductoCiudad(id);
    }
}
