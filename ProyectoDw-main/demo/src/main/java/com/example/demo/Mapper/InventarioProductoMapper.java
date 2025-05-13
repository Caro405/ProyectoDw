package com.example.demo.Mapper;

import com.example.demo.Model.InventarioProducto;
import com.example.demo.dto.InventarioProductoDTO;
import com.example.demo.Model.Producto;
import com.example.demo.Model.Inventario;
import com.example.demo.Model.Caravana;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventarioProductoMapper {

    InventarioProductoMapper INSTANCE = Mappers.getMapper(InventarioProductoMapper.class);

    @Mapping(source = "producto.id", target = "productoId")
    @Mapping(source = "inventario.id", target = "inventarioId")
    InventarioProductoDTO inventarioProductoToInventarioProductoDTO(InventarioProducto inventarioProducto);

    @Mapping(source = "productoId", target = "producto")
    @Mapping(source = "inventarioId", target = "inventario")
    InventarioProducto inventarioProductoDTOToInventarioProducto(InventarioProductoDTO inventarioProductoDTO);

    // Métodos para mapear Long a las entidades correspondientes
    Producto mapProducto(Long productoId);  // Método específico para Producto
    Inventario mapInventario(Long inventarioId);  // Método específico para Inventario
    Caravana mapCaravana(Long caravanaId);  // Método específico para Caravana
}
