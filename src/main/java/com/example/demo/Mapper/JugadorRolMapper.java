package com.example.demo.Mapper;

import com.example.demo.Model.*;
import com.example.demo.dto.JugadorRolDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface JugadorRolMapper {

    @Mapping(source = "jugador.id", target = "jugadorId")
    @Mapping(source = "rol.id", target = "rolId")
    JugadorRolDTO toDTO(JugadorRol entity);

    @Mapping(source = "jugadorId", target = "jugador")
    @Mapping(source = "rolId", target = "rol")
    @Mapping(target = "id", ignore = true)
    JugadorRol toEntity(JugadorRolDTO dto);

    default Jugador mapJugador(Long id) {
        if (id == null) return null;
        Jugador j = new Jugador();
        j.setId(id);
        return j;
    }

    default Rol mapRol(Long id) {
        if (id == null) return null;
        Rol r = new Rol();
        r.setId(id);
        return r;
    }
}