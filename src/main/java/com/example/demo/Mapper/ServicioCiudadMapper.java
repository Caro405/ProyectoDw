package com.example.demo.Mapper;

import com.example.demo.Model.ServicioCiudad;
import com.example.demo.dto.ServicioCiudadDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServicioCiudadMapper {

    ServicioCiudadMapper INSTANCE = Mappers.getMapper(ServicioCiudadMapper.class);

    @Mapping(source = "servicio.id", target = "servicioId")
    @Mapping(source = "ciudad.id", target = "ciudadId")
    ServicioCiudadDTO toDTO(ServicioCiudad servicioCiudad);

    @Mapping(target = "servicio", ignore = true)
    @Mapping(target = "ciudad", ignore = true)
    ServicioCiudad toEntity(ServicioCiudadDTO dto);
}
