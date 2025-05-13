package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long>{

}
