package com.example.demo.Mapper;

import com.example.demo.Model.Jugador;
import com.example.demo.Model.JugadoresSesion;
import com.example.demo.Model.SesionJuego;
import com.example.demo.dto.JugadoresSesionDTO;
import org.springframework.stereotype.Component;

@Component
public class JugadoresSesionMapper {

    // Convertir de JugadoresSesion a JugadoresSesionDTO
    public JugadoresSesionDTO jugadoresSesionToJugadoresSesionDTO(JugadoresSesion jugadoresSesion) {
        if (jugadoresSesion == null) {
            return null;
        }

        return new JugadoresSesionDTO(
            jugadoresSesion.getId(),
            jugadoresSesion.getJugador() != null ? jugadoresSesion.getJugador().getId() : null,
            jugadoresSesion.getSesionJuego() != null ? jugadoresSesion.getSesionJuego().getId() : null
        );
    }

    // Convertir de JugadoresSesionDTO a JugadoresSesion
    public JugadoresSesion jugadoresSesionDTOToJugadoresSesion(JugadoresSesionDTO jugadoresSesionDTO) {
        if (jugadoresSesionDTO == null) {
            return null;
        }

        Jugador jugador = new Jugador();
        jugador.setId(jugadoresSesionDTO.getJugadorId());

        SesionJuego sesionJuego = new SesionJuego();
        sesionJuego.setId(jugadoresSesionDTO.getSesionJuegoId());

        return new JugadoresSesion(jugador, sesionJuego);
    }
}
