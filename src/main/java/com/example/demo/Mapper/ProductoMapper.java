package com.example.demo.Mapper;

import com.example.demo.Model.Producto;
import com.example.demo.dto.ProductoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoDTO toDTO(Producto producto);
    Producto toEntity(ProductoDTO productoDTO);
}
