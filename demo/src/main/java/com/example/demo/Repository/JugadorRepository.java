package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Jugador;


public interface JugadorRepository extends JpaRepository<Jugador, Long>  {

}
