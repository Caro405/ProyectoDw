package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Ruta;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {
=======

import com.example.demo.Model.Ruta;

public interface RutaRepository extends JpaRepository<Ruta, Long>{

>>>>>>> main
}
