package com.example.demo.Mapper;

import com.example.demo.Model.*;
import com.example.demo.dto.ProductoInventarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoInventarioMapper {

    ProductoInventarioMapper INSTANCE = Mappers.getMapper(ProductoInventarioMapper.class);

    @Mapping(source = "inventario.id", target = "inventarioId")
    @Mapping(source = "producto.id", target = "productoId")
    ProductoInventarioDTO toDTO(ProductoInventario entity);

    @Mapping(source = "inventarioId", target = "inventario")
    @Mapping(source = "productoId", target = "producto")
    ProductoInventario toEntity(ProductoInventarioDTO dto);

    List<ProductoInventarioDTO> toDTOList(List<ProductoInventario> entities);

    default Inventario mapInventario(Long id) {
        if (id == null) return null;
        Inventario i = new Inventario();
        i.setId(id);
        return i;
    }

    default Producto mapProducto(Long id) {
        if (id == null) return null;
        Producto p = new Producto();
        p.setId(id);
        return p;
    }
}
