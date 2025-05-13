package com.example.demo.Mapper;

import com.example.demo.Model.Servicio;
import com.example.demo.dto.ServicioDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServicioMapper {

    ServicioMapper INSTANCE = Mappers.getMapper(ServicioMapper.class);

    ServicioDTO toDTO(Servicio servicio);

    Servicio toEntity(ServicioDTO servicioDTO);
}

