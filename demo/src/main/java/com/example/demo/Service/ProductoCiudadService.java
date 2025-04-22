package com.example.demo.Service;

import com.example.demo.Model.ProductoCiudad;
import com.example.demo.Model.Producto;
import com.example.demo.Model.Ciudad;
import com.example.demo.dto.ProductoCiudadDTO;
import com.example.demo.mapper.ProductoCiudadMapper;
import com.example.demo.Repository.ProductoCiudadRepository;
import com.example.demo.Repository.CiudadRepository;
import com.example.demo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoCiudadService {

    @Autowired
    private ProductoCiudadRepository productoCiudadRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    private final ProductoCiudadMapper mapper = ProductoCiudadMapper.INSTANCE;

    // Listar todas las relaciones
    public List<ProductoCiudadDTO> listarTodas() {
        return productoCiudadRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener por ID
    public Optional<ProductoCiudadDTO> obtenerPorId(Long id) {
        return productoCiudadRepository.findById(id).map(mapper::toDTO);
    }

    // Guardar o actualizar relación producto-ciudad
    public ProductoCiudadDTO guardar(ProductoCiudadDTO dto) {
        ProductoCiudad entity = mapper.toEntity(dto);

        // Asegurarse de asociar producto y ciudad si solo viene el ID
        Optional<Producto> producto = productoRepository.findById(dto.getProducto().getId());
        Optional<Ciudad> ciudad = ciudadRepository.findById(dto.getCiudad().getId());

        producto.ifPresent(entity::setProducto);
        ciudad.ifPresent(entity::setCiudad);

        ProductoCiudad guardado = productoCiudadRepository.save(entity);
        return mapper.toDTO(guardado);
    }

    // Eliminar relación
    public void eliminar(Long id) {
        productoCiudadRepository.deleteById(id);
    }
}
