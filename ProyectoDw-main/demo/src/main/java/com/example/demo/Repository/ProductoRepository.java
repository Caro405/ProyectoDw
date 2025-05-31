package com.example.demo.Repository;

import com.example.demo.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Consulta personalizada para obtener productos por ciudad, usando ProductoCiudad
    @Query("SELECT pc.producto FROM ProductoCiudad pc WHERE pc.ciudad.id = :ciudadId")
    List<Producto> findProductosByCiudadId(@Param("ciudadId") Long ciudadId);

}
