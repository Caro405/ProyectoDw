package com.example.demo.Mapper;

import com.example.demo.Model.Jugador;
import com.example.demo.dto.JugadorDTO;
import org.springframework.stereotype.Component;

@Component
public class JugadorMapper {

    // Convertir de Jugador a JugadorDTO
    public JugadorDTO jugadorToJugadorDTO(Jugador jugador) {
        if (jugador == null) {
            return null;
        }

        return new JugadorDTO(
            jugador.getId(),
            jugador.getNombre(),
            // Aquí puedes agregar la relación con la sesión si es necesario
            jugador.getSesiones() != null && !jugador.getSesiones().isEmpty() ? jugador.getSesiones().get(0).getSesionJuego().getId() : null
        );
    }

    // Convertir de JugadorDTO a Jugador
    public Jugador jugadorDTOToJugador(JugadorDTO jugadorDTO) {
        if (jugadorDTO == null) {
            return null;
        }

        return new Jugador(jugadorDTO.getNombre());
    }
}
