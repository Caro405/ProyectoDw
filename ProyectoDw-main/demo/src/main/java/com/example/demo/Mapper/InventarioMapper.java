package com.example.demo.Mapper;

import com.example.demo.Model.Inventario;
import com.example.demo.Model.Caravana;  // Asegúrate de importar la clase Caravana
import com.example.demo.dto.InventarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventarioMapper {

    InventarioMapper INSTANCE = Mappers.getMapper(InventarioMapper.class);

    @Mapping(source = "caravana.id", target = "caravanaId")
    InventarioDTO toDTO(Inventario inventario);

    @Mapping(source = "caravanaId", target = "caravana")
    Inventario toEntity(InventarioDTO inventarioDTO);

    // Método para convertir Long a Caravana
    Caravana map(Long caravanaId);  // Método para mapear un Long a un objeto Caravana
}
