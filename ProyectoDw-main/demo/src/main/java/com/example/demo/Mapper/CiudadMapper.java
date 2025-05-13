package com.example.demo.Mapper;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.Model.Ciudad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CiudadMapper {

    CiudadMapper INSTANCE = Mappers.getMapper(CiudadMapper.class);

    @Mapping(source = "rutasSalida", target = "rutasSalida")
    @Mapping(source = "rutasLlegada", target = "rutasLlegada")
    @Mapping(source = "productos", target = "productos")
    CiudadDTO toDTO(Ciudad ciudad);

    @Mapping(source = "rutasSalida", target = "rutasSalida")
    @Mapping(source = "rutasLlegada", target = "rutasLlegada")
    @Mapping(source = "productos", target = "productos")
    Ciudad toEntity(CiudadDTO ciudadDTO);
}
