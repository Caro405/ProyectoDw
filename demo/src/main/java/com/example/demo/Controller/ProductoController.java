package com.example.demo.Controller;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ProductoDTO getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public ProductoDTO createProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.createProducto(productoDTO);
    }

    @PutMapping("/{id}")
    public ProductoDTO updateProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        return productoService.updateProducto(id, productoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }
}
