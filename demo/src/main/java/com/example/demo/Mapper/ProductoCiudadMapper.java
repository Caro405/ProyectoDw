package com.example.demo.mapper;

import com.example.demo.Model.ProductoCiudad;
import com.example.demo.dto.ProductoCiudadDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductoCiudadMapper {
    ProductoCiudadMapper INSTANCE = Mappers.getMapper(ProductoCiudadMapper.class);

    ProductoCiudadDTO toDTO(ProductoCiudad productoCiudad);
    ProductoCiudad toEntity(ProductoCiudadDTO productoCiudadDTO);
}
