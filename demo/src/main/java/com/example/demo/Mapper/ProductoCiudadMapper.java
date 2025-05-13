package com.example.demo.Mapper;

import com.example.demo.Model.ProductoCiudad;
import com.example.demo.dto.ProductoCiudadDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductoCiudadMapper {
    ProductoCiudadMapper INSTANCE = Mappers.getMapper(ProductoCiudadMapper.class);

    ProductoCiudadDTO toDTO(ProductoCiudad productoCiudad);
    ProductoCiudad toEntity(ProductoCiudadDTO productoCiudadDTO);
}
