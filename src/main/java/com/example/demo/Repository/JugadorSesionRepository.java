package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Jugador;
import com.example.demo.Model.JugadorSesion;

public interface JugadorSesionRepository extends JpaRepository<JugadorSesion, Long> {

}
