package com.example.demo.Mapper;

import com.example.demo.Model.DetalleVenta;
import com.example.demo.dto.DetalleVentaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleVentaMapper {

    @Mapping(source = "producto.id", target = "productoId")
    DetalleVentaDTO toDTO(DetalleVenta detalleVenta);

    @Mapping(source = "productoId", target = "producto")
    DetalleVenta toEntity(DetalleVentaDTO detalleVentaDTO);

    List<DetalleVentaDTO> toDTOList(List<DetalleVenta> detalles);

    default com.example.demo.Model.Producto mapProducto(Long id) {
        if (id == null) return null;
        com.example.demo.Model.Producto p = new com.example.demo.Model.Producto();
        p.setId(id);
        return p;
    }
}
