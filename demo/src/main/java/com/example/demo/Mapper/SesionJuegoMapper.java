package com.example.demo.Mapper;

import com.example.demo.Model.SesionJuego;
import com.example.demo.dto.SesionJuegoDTO;
import org.springframework.stereotype.Component;

@Component
public class SesionJuegoMapper {

    // Convertir de SesionJuego a SesionJuegoDTO
    public SesionJuegoDTO sesionJuegoToSesionJuegoDTO(SesionJuego sesionJuego) {
        if (sesionJuego == null) {
            return null;
        }

        return new SesionJuegoDTO(
            sesionJuego.getId(),
            sesionJuego.getNombre(),
            sesionJuego.getOro_maximo(),
            sesionJuego.getFecha_inicio(),
            sesionJuego.getFecha_fin()
        );
    }

    // Convertir de SesionJuegoDTO a SesionJuego
    public SesionJuego sesionJuegoDTOToSesionJuego(SesionJuegoDTO sesionJuegoDTO) {
        if (sesionJuegoDTO == null) {
            return null;
        }

        return new SesionJuego(
            sesionJuegoDTO.getNombre(),
            sesionJuegoDTO.getOro_maximo(),
            sesionJuegoDTO.getFecha_inicio(),
            sesionJuegoDTO.getFecha_fin()
        );
    }
}
