package com.example.demo.Mapper;

import com.example.demo.Model.Jugador;
import com.example.demo.dto.JugadorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JugadorMapper {

    JugadorMapper INSTANCE = Mappers.getMapper(JugadorMapper.class);

    JugadorDTO jugadorToJugadorDTO(Jugador jugador);

    Jugador jugadorDTOToJugador(JugadorDTO jugadorDTO);
}
