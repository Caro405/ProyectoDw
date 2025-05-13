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
                ruta.getCiudadOrigen().getId(),
                ruta.getCiudadDestino().getId(),
                ruta.getCiudadOrigen().getNombre(),
                ruta.getCiudadDestino().getNombre()
        );
    }

    public static Ruta toEntity(RutaDTO rutaDTO, Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        Ruta ruta = new Ruta();
        ruta.setId(rutaDTO.getId());
        ruta.setDistancia(rutaDTO.getDistancia());
        ruta.setEsSegura(rutaDTO.isEsSegura());
        ruta.setAtaque(rutaDTO.getAtaque());
        ruta.setCausaAtaque(rutaDTO.getCausaAtaque());
        ruta.setCiudadOrigen(ciudadOrigen);
        ruta.setCiudadDestino(ciudadDestino);
        return ruta;
    }
}
