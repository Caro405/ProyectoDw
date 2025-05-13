package com.example.demo.Mapper;

import com.example.demo.Model.Jugador;
import com.example.demo.Model.JugadoresSesion;
import com.example.demo.dto.JugadoresSesionDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface JugadoresSesionMapper {
    JugadoresSesionMapper INSTANCE = Mappers.getMapper(JugadoresSesionMapper.class);

    JugadoresSesionDTO toDTO(Jugador jugadoresSesion);
    JugadoresSesion toEntity(JugadoresSesionDTO jugadoresSesionDTO);
}
