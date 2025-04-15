package com.example.demo.Service;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.Mapper.ProductoMapper;
import com.example.demo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Listar todos los productos
    public List<ProductoDTO> listarProductos() {
        return productoRepository.findAll().stream()
                .map(ProductoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener un producto por su ID
    public Optional<ProductoDTO> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id)
                .map(ProductoMapper::toDTO);
    }

    // Guardar un nuevo producto
    public void guardarProducto(ProductoDTO productoDTO) {
        productoRepository.save(ProductoMapper.toEntity(productoDTO));
    }

    // Eliminar un producto por su ID
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
