package com.example.demo.Service;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.Model.Producto;
import com.example.demo.Mapper.ProductoMapper;
import com.example.demo.Repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    // Obtener todos los productos
    public List<ProductoDTO> getAllProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener producto por ID
    public ProductoDTO getProductoById(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Producto no encontrado con id: " + id));
        return productoMapper.toDTO(producto);
    }

    // Crear nuevo producto
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        Producto producto = productoMapper.toEntity(productoDTO);
        Producto savedProducto = productoRepository.save(producto);
        return productoMapper.toDTO(savedProducto);
    }

    // Actualizar producto existente
    public ProductoDTO updateProducto(Long id, ProductoDTO productoDTO) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Producto no encontrado con id: " + id));

        producto.setNombre(productoDTO.getNombre());
        producto.setCategoria(productoDTO.getCategoria());
        producto.setPrecioBase(productoDTO.getPrecioBase());
        producto.setFactorOferta(productoDTO.getFactorOferta());
        producto.setFactorDemanda(productoDTO.getFactorDemanda());

        Producto updatedProducto = productoRepository.save(producto);
        return productoMapper.toDTO(updatedProducto);
    }

    // Eliminar producto
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
