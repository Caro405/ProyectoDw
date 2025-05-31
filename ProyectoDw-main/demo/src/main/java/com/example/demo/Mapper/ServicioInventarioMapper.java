package com.example.demo.Mapper;

import com.example.demo.Model.*;
import com.example.demo.dto.ServicioInventarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicioInventarioMapper {

    ServicioInventarioMapper INSTANCE = Mappers.getMapper(ServicioInventarioMapper.class);

    @Mapping(source = "inventario.id", target = "inventarioId")
    @Mapping(source = "servicio.id", target = "servicioId")
    ServicioInventarioDTO toDTO(ServicioInventario entity);

    @Mapping(source = "inventarioId", target = "inventario")
    @Mapping(source = "servicioId", target = "servicio")
    ServicioInventario toEntity(ServicioInventarioDTO dto);

    List<ServicioInventarioDTO> toDTOList(List<ServicioInventario> entities);

    default Inventario mapInventario(Long id) {
        if (id == null) return null;
        Inventario i = new Inventario();
        i.setId(id);
        return i;
    }

    default Servicio mapServicio(Long id) {
        if (id == null) return null;
        Servicio s = new Servicio();
        s.setId(id);
        return s;
    }
}
