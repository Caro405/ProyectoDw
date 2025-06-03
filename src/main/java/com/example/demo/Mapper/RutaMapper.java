package com.example.demo.Mapper;

import com.example.demo.Model.*;
import com.example.demo.dto.RutaDTO;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface RutaMapper {

    @Mapping(source = "ciudadOrigen.id", target = "ciudadOrigenId")
    @Mapping(source = "ciudadOrigen.nombre", target = "ciudadOrigenNombre")
    @Mapping(source = "ciudadDestino.id", target = "ciudadDestinoId")
    @Mapping(source = "ciudadDestino.nombre", target = "ciudadDestinoNombre")
    RutaDTO toDTO(Ruta ruta);

    @Mapping(target = "ciudadOrigen", ignore = true)
    @Mapping(target = "ciudadDestino", ignore = true)
    Ruta toEntity(RutaDTO rutaDTO);

    default Ruta toEntityWithCiudades(RutaDTO rutaDTO, Ciudad origen, Ciudad destino) {
        Ruta ruta = toEntity(rutaDTO);
        ruta.setCiudadOrigen(origen);
        ruta.setCiudadDestino(destino);
        return ruta;
    }
}