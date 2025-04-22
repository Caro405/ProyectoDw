package com.example.demo.Repository;

import com.example.demo.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Método para obtener productos por ID de ciudad
    List<Producto> findByCiudadId(Long ciudadId);
}
