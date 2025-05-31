package com.example.demo.Mapper;

import com.example.demo.Model.Jugador;
import com.example.demo.Model.JugadorSesion;
import com.example.demo.dto.JugadorSesionDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface JugadorSesionMapper {
    JugadorSesionMapper INSTANCE = Mappers.getMapper(JugadorSesionMapper.class);

    JugadorSesionDTO toDTO(JugadorSesion jugadorSesion);
    JugadorSesion toEntity(JugadorSesionDTO jugadorSesionDTO);

}
