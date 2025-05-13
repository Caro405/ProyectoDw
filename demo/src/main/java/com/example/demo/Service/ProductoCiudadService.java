package com.example.demo.Service;

import com.example.demo.dto.ProductoCiudadDTO;
import com.example.demo.Model.ProductoCiudad;
import com.example.demo.Repository.ProductoCiudadRepository;
import com.example.demo.Mapper.ProductoCiudadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoCiudadService {

    @Autowired
    private ProductoCiudadRepository productoCiudadRepository;

    private final ProductoCiudadMapper productoCiudadMapper = ProductoCiudadMapper.INSTANCE;

    // Obtener todas las relaciones producto-ciudad
    public List<ProductoCiudadDTO> getAllProductoCiudad() {
        List<ProductoCiudad> relaciones = productoCiudadRepository.findAll();
        return relaciones.stream()
                .map(productoCiudadMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener producto-ciudad por ID
    public Optional<ProductoCiudadDTO> getProductoCiudadById(Long id) {
        ProductoCiudad productoCiudad = productoCiudadRepository.findById(id).orElseThrow();
        return Optional.of(productoCiudadMapper.toDTO(productoCiudad));
    }

    // Crear una nueva relación producto-ciudad
    public ProductoCiudadDTO createProductoCiudad(ProductoCiudadDTO productoCiudadDTO) {
        ProductoCiudad productoCiudad = productoCiudadMapper.toEntity(productoCiudadDTO);
        ProductoCiudad savedProductoCiudad = productoCiudadRepository.save(productoCiudad);
        return productoCiudadMapper.toDTO(savedProductoCiudad);
    }

    // Actualizar la relación producto-ciudad
    public ProductoCiudadDTO updateProductoCiudad(Long id, ProductoCiudadDTO productoCiudadDTO) {
        ProductoCiudad productoCiudad = productoCiudadRepository.findById(id).orElseThrow();
        productoCiudad.setPrecio(productoCiudadDTO.getPrecio());
        productoCiudad.setFactorDemanda(productoCiudadDTO.getFactorDemanda());
        productoCiudad.setFactorOferta(productoCiudadDTO.getFactorOferta());
        productoCiudad.setStock(productoCiudadDTO.getStock());
        productoCiudadRepository.save(productoCiudad);
        return productoCiudadMapper.toDTO(productoCiudad);
    }

    // Eliminar la relación producto-ciudad
    public void deleteProductoCiudad(Long id) {
        productoCiudadRepository.deleteById(id);
    }
}
