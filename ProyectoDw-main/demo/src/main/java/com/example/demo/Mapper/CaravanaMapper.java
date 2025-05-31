package com.example.demo.Mapper;

import com.example.demo.Model.*;
import com.example.demo.dto.CaravanaDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CaravanaMapper {

    CaravanaMapper INSTANCE = Mappers.getMapper(CaravanaMapper.class);

    @Mapping(source = "inventario.id", target = "inventarioId")
    @Mapping(source = "jugadores", target = "jugadoresIds", qualifiedByName = "jugadoresToIds")
    CaravanaDTO toDTO(Caravana entity);

    @Mapping(source = "inventarioId", target = "inventario")
    @Mapping(source = "jugadoresIds", target = "jugadores", qualifiedByName = "idsToJugadores")
    Caravana toEntity(CaravanaDTO dto);

    List<CaravanaDTO> toDTOList(List<Caravana> entities);

    @Named("jugadoresToIds")
    default List<Long> jugadoresToIds(List<Jugador> jugadores) {
        if (jugadores == null) return null;
        return jugadores.stream()
                .map(Jugador::getId)
                .collect(Collectors.toList());
    }

    @Named("idsToJugadores")
    default List<Jugador> idsToJugadores(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> {
                    Jugador j = new Jugador();
                    j.setId(id);
                    return j;
                }).collect(Collectors.toList());
    }

    default Inventario mapInventario(Long id) {
        if (id == null) return null;
        Inventario i = new Inventario();
        i.setId(id);
        return i;
    }
}

