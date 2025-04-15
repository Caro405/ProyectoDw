package com.example.demo.Mapper;

import com.example.demo.dto.JugadorDTO;
import com.example.demo.Model.Jugador;

public class JugadorMapper {

    // Convertir de Jugador a JugadorDTO
    public static JugadorDTO toDTO(Jugador jugador) {
        return new JugadorDTO(
            jugador.getId(),
            jugador.getNombre()
        );
    }

    // Convertir de JugadorDTO a Jugador
    public static Jugador toEntity(JugadorDTO jugadorDTO) {
        return new Jugador(
            jugadorDTO.getNombre()

        );
    }
}
