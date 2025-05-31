package com.example.demo.Repository;

import com.example.demo.Model.ProductoCiudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCiudadRepository extends JpaRepository<ProductoCiudad, Long> {
}
