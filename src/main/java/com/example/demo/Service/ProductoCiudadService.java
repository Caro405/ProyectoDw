package com.example.demo.Service;

import com.example.demo.Model.ProductoCiudad;
import com.example.demo.Repository.ProductoCiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoCiudadService {

    @Autowired
    private ProductoCiudadRepository productoCiudadRepository;

    public List<ProductoCiudad> getAllProductoCiudad() {
        return productoCiudadRepository.findAll();
    }

    public Optional<ProductoCiudad> getProductoCiudadById(Long id) {
        return productoCiudadRepository.findById(id);
    }

    public ProductoCiudad createProductoCiudad(ProductoCiudad productoCiudad) {
        return productoCiudadRepository.save(productoCiudad);
    }

    public ProductoCiudad updateProductoCiudad(Long id, ProductoCiudad updatedProductoCiudad) {
        return productoCiudadRepository.findById(id)
                .map(pc -> {
                    pc.setPrecio(updatedProductoCiudad.getPrecio());
                    pc.setFactorDemanda(updatedProductoCiudad.getFactorDemanda());
                    pc.setFactorOferta(updatedProductoCiudad.getFactorOferta());
                    pc.setStock(updatedProductoCiudad.getStock());
                    pc.setProducto(updatedProductoCiudad.getProducto());
                    pc.setCiudad(updatedProductoCiudad.getCiudad());
                    return productoCiudadRepository.save(pc);
                }).orElseThrow(() -> new RuntimeException("ProductoCiudad no encontrado con id " + id));
    }

    public void deleteProductoCiudad(Long id) {
        productoCiudadRepository.deleteById(id);
    }
}
