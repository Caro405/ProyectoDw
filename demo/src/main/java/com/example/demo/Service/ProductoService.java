package com.example.demo.Service;

import com.example.demo.Repository.ProductoRepository;
import com.example.demo.Model.Producto;
import com.example.demo.Mapper.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.example.demo.Service.JugadorService;
import com.example.demo.Service.CiudadService;
import com.example.demo.Service.RutaService;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.Service.ServicioService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.Model.Jugador;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Listar todos los productos
    public List<ProductoDTO> listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream().map(ProductoMapper::toDTO).collect(Collectors.toList());
    }

    // Listar productos con paginación
    public Page<ProductoDTO> listarProductosConPaginacion(int page, int size) {
        Page<Producto> productosPage = productoRepository.findAll(PageRequest.of(page, size));
        return productosPage.map(ProductoMapper::toDTO);
    }

    // Obtener producto por ID
    public Optional<ProductoDTO> obtenerProductoPorId(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.map(ProductoMapper::toDTO);
    }

    // Guardar producto
    public ProductoDTO guardarProducto(ProductoDTO productoDTO) {
        Producto producto = ProductoMapper.toEntity(productoDTO);
        Producto savedProducto = productoRepository.save(producto);
        return ProductoMapper.toDTO(savedProducto);
    }

    // Eliminar producto
    public void eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }
}
