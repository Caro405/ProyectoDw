package com.example.demo.Repository;

<<<<<<< HEAD
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    Optional<Ciudad> findByNombre(String nombre);
=======
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long>{

>>>>>>> main
}
