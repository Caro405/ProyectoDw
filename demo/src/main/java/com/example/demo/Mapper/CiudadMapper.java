package com.example.demo.Mapper;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.Model.Ciudad;

public class CiudadMapper {

    public static CiudadDTO toDTO(Ciudad ciudad) {
        CiudadDTO dto = new CiudadDTO();
        dto.setId(ciudad.getId());
        dto.setNombre(ciudad.getNombre());
        dto.setImpuestos(ciudad.getImpuestos());
        return dto;
    }

    public static Ciudad toEntity(CiudadDTO dto) {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(dto.getId());
        ciudad.setNombre(dto.getNombre());
        ciudad.setImpuestos(dto.getImpuestos());
        return ciudad;
    }
}
