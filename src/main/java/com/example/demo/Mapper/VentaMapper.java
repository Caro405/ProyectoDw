package com.example.demo.Mapper;

import com.example.demo.Model.*;
import com.example.demo.dto.VentaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DetalleVentaMapper.class})
public interface VentaMapper {

    VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);

    @Mapping(source = "caravana.id", target = "caravanaId")
    @Mapping(source = "ciudad.id", target = "ciudadId")
    @Mapping(source = "detalles", target = "detalles")
    VentaDTO toDTO(Venta entity);

    @Mapping(source = "caravanaId", target = "caravana")
    @Mapping(source = "ciudadId", target = "ciudad")
    @Mapping(source = "detalles", target = "detalles")
    Venta toEntity(VentaDTO dto);

    List<VentaDTO> toDTOList(List<Venta> entities);

    default Caravana mapCaravana(Long id) {
        if (id == null) return null;
        Caravana c = new Caravana();
        c.setId(id);
        return c;
    }

    default Ciudad mapCiudad(Long id) {
        if (id == null) return null;
        Ciudad c = new Ciudad();
        c.setId(id);
        return c;
    }
}
