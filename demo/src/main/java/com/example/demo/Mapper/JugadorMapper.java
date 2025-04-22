package com.example.demo.mapper;

import com.example.demo.Model.Jugador;
import com.example.demo.dto.JugadorDTO;

public class JugadorMapper {

    // Convertir de Jugador a JugadorDTO
    public static JugadorDTO toDTO(Jugador jugador) {
        if (jugador == null) {
            return null;
        }
        Long sesionJuegoId = null; 
        return new JugadorDTO(
            jugador.getId(),
            jugador.getNombre(),
            sesionJuegoId // Pasar el sesionJuegoId desde la entidad Jugador
        );
    }

    // Convertir de JugadorDTO a Jugador
    public static Jugador toEntity(JugadorDTO jugadorDTO) {
        if (jugadorDTO == null) {
            return null;
        }
        Jugador jugador = new Jugador();
        jugador.setId(jugadorDTO.getId());
        jugador.setNombre(jugadorDTO.getNombre());
        // Si se necesita asignar sesionJuegoId, se agrega la lógica aquí
        // Por ejemplo, si tienes un método para asignar la sesión de juego, lo agregas aquí
        return jugador;
    }
}
