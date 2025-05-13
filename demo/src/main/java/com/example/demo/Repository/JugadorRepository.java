package com.example.demo.Repository;

import com.example.demo.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    // Método para buscar jugadores por nombre
    List<Jugador> findAllByNombre(String nombre);

    // Método para buscar jugadores cuyo nombre comienza con un texto dado
    List<Jugador> findAllByNombreStartingWith(String nombre);

    // Método para buscar jugadores cuyo nombre comienza con un texto dado, ignorando mayúsculas/minúsculas
    List<Jugador> findAllByNombreStartingWithIgnoreCase(String nombre);

    // JPQL: Buscar jugadores por nombre, sin tener en cuenta mayúsculas/minúsculas
    @Query("SELECT j FROM Jugador j WHERE LOWER(j.nombre) LIKE LOWER(concat(:nombre, '%'))")
    List<Jugador> buscarPorNombreInsensitive(String nombre);
}
