package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long>{

}
