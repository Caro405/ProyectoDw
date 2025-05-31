package com.example.demo.Mapper;

import com.example.demo.Model.*;
import com.example.demo.dto.InventarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductoInventarioMapper.class, ServicioInventarioMapper.class})
public interface InventarioMapper {

    InventarioMapper INSTANCE = Mappers.getMapper(InventarioMapper.class);

    @Mapping(source = "caravana.id", target = "caravanaId")
    InventarioDTO toDTO(Inventario entity);

    @Mapping(source = "caravanaId", target = "caravana")
    Inventario toEntity(InventarioDTO dto);

    List<InventarioDTO> toDTOList(List<Inventario> entities);

    default Caravana mapCaravana(Long id) {
        if (id == null) return null;
        Caravana c = new Caravana();
        c.setId(id);
        return c;
    }
}
