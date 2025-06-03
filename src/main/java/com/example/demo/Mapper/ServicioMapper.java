package com.example.demo.Mapper;

import com.example.demo.Model.Servicio;
import com.example.demo.dto.ServicioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ServicioMapper {
    ServicioDTO toDTO(Servicio servicio);
    Servicio toEntity(ServicioDTO servicioDTO);
}
