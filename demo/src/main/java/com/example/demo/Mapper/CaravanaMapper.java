package com.example.demo.Mapper;

import com.example.demo.Model.Caravana;
import com.example.demo.dto.CaravanaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CaravanaMapper {


    @Mapping(source = "inventario", target = "inventarioDTO")
    @Mapping(source = "jugador", target = "jugadorDTO")
    CaravanaDTO toDTO(Caravana caravana);

    @Mapping(source = "inventarioDTO", target = "inventario")
    @Mapping(source = "jugadorDTO", target = "jugador")
    Caravana toEntity(CaravanaDTO caravanaDTO);
}

