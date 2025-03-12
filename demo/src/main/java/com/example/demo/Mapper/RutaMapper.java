package com.example.demo.Mapper;

import com.example.demo.dto.RutaDTO;
import com.example.demo.Model.Ciudad;
import com.example.demo.Model.Ruta;

public class RutaMapper {
    public static RutaDTO toDTO(Ruta ruta) {
        return new RutaDTO(
            ruta.getId(),
            ruta.getDistancia(),
            ruta.isEsSegura(),
            ruta.getAtaque(), 
            ruta.getCausaAtaque(), 
            ruta.getCiudadOrigen() != null ? ruta.getCiudadOrigen().getId() : null,
            ruta.getCiudadDestino() != null ? ruta.getCiudadDestino().getId() : null
        );
    }

    public static Ruta toEntity(RutaDTO rutaDTO, Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return new Ruta(
            rutaDTO.getDistancia(),
            rutaDTO.isEsSegura(),
            rutaDTO.getAtaque(),
            rutaDTO.getCausaAtaque()
        );
    }
}
