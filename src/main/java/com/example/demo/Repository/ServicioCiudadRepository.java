package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ServicioCiudad;

@Repository
public interface ServicioCiudadRepository extends JpaRepository<ServicioCiudad, Long> {

}
