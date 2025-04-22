package com.example.demo.Mapper;

import com.example.demo.Model.SesionJuego;
import com.example.demo.dto.SesionJuegoDTO;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class SesionJuegoMapper {

    // Convertir de SesionJuego a SesionJuegoDTO
    public SesionJuegoDTO sesionJuegoToSesionJuegoDTO(SesionJuego sesionJuego) {
        if (sesionJuego == null) {
            return null;
        }

        // Convertimos LocalDate a java.sql.Date
        Date fechaInicio = Date.valueOf(sesionJuego.getFecha_inicio());
        Date fechaFin = Date.valueOf(sesionJuego.getFecha_fin());

        return new SesionJuegoDTO(
            sesionJuego.getId(),
            sesionJuego.getNombre(),
            sesionJuego.getOro_maximo(),
            fechaInicio,  // Pasamos java.sql.Date
            fechaFin      // Pasamos java.sql.Date
        );
    }

    // Convertir de SesionJuegoDTO a SesionJuego
    public SesionJuego sesionJuegoDTOToSesionJuego(SesionJuegoDTO sesionJuegoDTO) {
        if (sesionJuegoDTO == null) {
            return null;
        }

        // Convertimos java.sql.Date a LocalDate
        java.time.LocalDate fechaInicio = sesionJuegoDTO.getFecha_inicio().toLocalDate();
        java.time.LocalDate fechaFin = sesionJuegoDTO.getFecha_fin().toLocalDate();

        return new SesionJuego(
            sesionJuegoDTO.getNombre(),
            sesionJuegoDTO.getOro_maximo(),
            fechaInicio,  // Usamos LocalDate
            fechaFin      // Usamos LocalDate
        );
    }
}
