package com.example.demo.Mapper;

import com.example.demo.Model.*;
import com.example.demo.dto.ProductoCiudadDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductoCiudadMapper {

    ProductoCiudadMapper INSTANCE = null;

    @Mapping(source = "producto.id", target = "productoId")
    @Mapping(source = "ciudad.id", target = "ciudadId")
    ProductoCiudadDTO toDTO(ProductoCiudad productoCiudad);

    @Mapping(source = "productoId", target = "producto")
    @Mapping(source = "ciudadId", target = "ciudad")
    ProductoCiudad toEntity(ProductoCiudadDTO productoCiudadDTO);

    default Producto mapProducto(Long id) {
        if (id == null) return null;
        Producto p = new Producto();
        p.setId(id);
        return p;
    }

    default Ciudad mapCiudad(Long id) {
        if (id == null) return null;
        Ciudad c = new Ciudad();
        c.setId(id);
        return c;
    }
}