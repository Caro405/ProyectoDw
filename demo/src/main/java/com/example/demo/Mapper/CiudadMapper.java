package com.example.demo.Mapper;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.Model.Ciudad;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CiudadMapper {

    CiudadMapper INSTANCE = Mappers.getMapper(CiudadMapper.class);

    CiudadDTO toDTO(Ciudad ciudad);

    Ciudad toEntity(CiudadDTO dto);
}
