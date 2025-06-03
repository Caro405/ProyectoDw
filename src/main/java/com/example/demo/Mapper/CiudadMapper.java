package com.example.demo.Mapper;

import com.example.demo.Model.Ciudad;
import com.example.demo.dto.CiudadDTO;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.ServicioDTO;
import com.example.demo.Model.ProductoCiudad;
import com.example.demo.Model.ServicioCiudad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {})
public abstract class CiudadMapper {

    @Autowired
    protected ProductoMapper productoMapper;

    @Autowired
    protected ServicioMapper servicioMapper;

    @Mapping(source = "rutasSalida", target = "rutasSalida")
    @Mapping(source = "rutasLlegada", target = "rutasLlegada")
    @Mapping(target = "productosCiudadIds", expression = "java(getProductoCiudadIds(ciudad))")
    @Mapping(target = "serviciosCiudadIds", expression = "java(getServicioCiudadIds(ciudad))")
    @Mapping(target = "productos", expression = "java(getProductos(ciudad))")
    @Mapping(target = "servicios", expression = "java(getServicios(ciudad))")
    public abstract CiudadDTO toDTO(Ciudad ciudad);

    public abstract Ciudad toEntity(CiudadDTO ciudadDTO);

    // Métodos auxiliares para mapear los IDs
    protected List<Long> getProductoCiudadIds(Ciudad ciudad) {
        if (ciudad.getProductosCiudad() == null) return Collections.emptyList();
        return ciudad.getProductosCiudad().stream()
                .map(ProductoCiudad::getId)
                .collect(Collectors.toList());
    }

    protected List<Long> getServicioCiudadIds(Ciudad ciudad) {
        if (ciudad.getServiciosCiudad() == null) return Collections.emptyList();
        return ciudad.getServiciosCiudad().stream()
                .map(ServicioCiudad::getId)
                .collect(Collectors.toList());
    }

    // Métodos auxiliares para mapear productos y servicios completos
    protected List<ProductoDTO> getProductos(Ciudad ciudad) {
        if (ciudad.getProductosCiudad() == null) return Collections.emptyList();
        return ciudad.getProductosCiudad().stream()
                .map(pc -> productoMapper.toDTO(pc.getProducto()))
                .collect(Collectors.toList());
    }

    protected List<ServicioDTO> getServicios(Ciudad ciudad) {
        if (ciudad.getServiciosCiudad() == null) return Collections.emptyList();
        return ciudad.getServiciosCiudad().stream()
                .map(sc -> servicioMapper.toDTO(sc.getServicio()))
                .collect(Collectors.toList());
    }
}
