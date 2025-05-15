package com.example.demo.Mapper;

import com.example.demo.Model.Inventario;
import com.example.demo.dto.InventarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InventarioMapper {

    @Mapping(source = "caravana.id", target = "caravanaId")
    InventarioDTO toDTO(Inventario inventario);

    @Mapping(source = "caravanaId", target = "caravana")
    Inventario toEntity(InventarioDTO inventarioDTO);

    // Método para convertir Long a Caravana
    default Caravana map(Long id) {
        if (id == null) {
            return null;
        }
        Caravana caravana = new Caravana();
        caravana.setId(id);
        return caravana;
    }

    // Método para convertir Caravana a Long (su id)
    default Long map(Caravana caravana) {
        if (caravana == null) {
            return null;
        }
        return caravana.getId();
    }
}
