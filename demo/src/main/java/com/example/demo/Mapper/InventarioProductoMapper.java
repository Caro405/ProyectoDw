package com.example.demo.Mapper;

import com.example.demo.Model.InventarioProducto;
import com.example.demo.dto.InventarioProductoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventarioProductoMapper {

   
    @Mapping(source = "producto.id", target = "productoId")
    @Mapping(source = "inventario.id", target = "inventarioId")
    InventarioProductoDTO inventarioProductoToInventarioProductoDTO(InventarioProducto inventarioProducto);

    @Mapping(source = "productoId", target = "producto")
    @Mapping(source = "inventarioId", target = "inventario")
    InventarioProducto inventarioProductoDTOToInventarioProducto(InventarioProductoDTO inventarioProductoDTO);
}
