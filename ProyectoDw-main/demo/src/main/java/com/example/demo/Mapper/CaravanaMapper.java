package com.example.demo.Mapper;

import com.example.demo.Model.Caravana;
import com.example.demo.dto.CaravanaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")  // Añadir esta anotación para que MapStruct registre el bean en Spring
public interface CaravanaMapper {

    CaravanaMapper INSTANCE = Mappers.getMapper(CaravanaMapper.class);

    @Mapping(source = "inventario", target = "inventarioDTO")  // Mapeo de Inventario
    CaravanaDTO toDTO(Caravana caravana);

    @Mapping(source = "inventarioDTO", target = "inventario")  // Mapeo de InventarioDTO a Inventario
    Caravana toEntity(CaravanaDTO caravanaDTO);

    // Mapeo de una lista de Caravana a una lista de CaravanaDTO
    List<CaravanaDTO> toDTOList(List<Caravana> caravanas);
}
