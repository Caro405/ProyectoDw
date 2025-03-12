package com.example.demo.Mapper;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.Model.Ciudad;

public class CiudadMapper {
    public static CiudadDTO toDTO(Ciudad ciudad) {
        return new CiudadDTO(ciudad.getId(), ciudad.getNombre(), ciudad.getImpuestos());
    }

    public static Ciudad toEntity(CiudadDTO ciudadDTO) {
        return new Ciudad(ciudadDTO.getNombre(), ciudadDTO.getImpuestos());
    }
}
