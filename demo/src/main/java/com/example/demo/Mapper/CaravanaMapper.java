package com.example.demo.Mapper;

import com.example.demo.dto.CaravanaDTO;
import com.example.demo.Model.Caravana;

public class CaravanaMapper {

    // Convertir de Caravana a CaravanaDTO
    public static CaravanaDTO toDTO(Caravana caravana) {
        return new CaravanaDTO(
            caravana.getId(),
            caravana.getNombre(),
            caravana.getVelocidad(),
            caravana.getCargaActual(),
            caravana.getCapacidadMaxCarga(),
            caravana.getDinero(),
            caravana.getPuntosVidaActual(),
            caravana.getPuntosVidaMax(),
            caravana.isGuardias()
        );
    }

    // Convertir de CaravanaDTO a Caravana
    public static Caravana toEntity(CaravanaDTO caravanaDTO) {
        return new Caravana(
            caravanaDTO.getNombre(),
            caravanaDTO.getVelocidad(),
            caravanaDTO.getCargaActual(),
            caravanaDTO.getCapacidadMaxCarga(),
            caravanaDTO.getDinero(),
            caravanaDTO.getPuntosVidaActual(),
            caravanaDTO.getPuntosVidaMax(),
            caravanaDTO.isGuardias()
        );
    }
}
