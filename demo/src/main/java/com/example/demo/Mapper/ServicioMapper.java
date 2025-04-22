package com.example.demo.Mapper;

import com.example.demo.Model.Servicio;
import com.example.demo.dto.ServicioDTO;
import com.example.demo.Model.Ciudad;

public class ServicioMapper {

    // Convertir de entidad Servicio a DTO
    public static ServicioDTO toDTO(Servicio servicio) {
        if (servicio == null) return null;
        return new ServicioDTO(
                servicio.getId(),
                servicio.getNombreservicio(),
                servicio.getPrecio(),
                servicio.getPorcentajeEfecto(),
                servicio.getCiudad().getId()  // Obtiene el ID de la ciudad asociada
        );
    }

    // Convertir de DTO a entidad Servicio
    public static Servicio toEntity(ServicioDTO servicioDTO, Ciudad ciudad) {
        if (servicioDTO == null) return null;
        Servicio servicio = new Servicio();
        servicio.setId(servicioDTO.getId());
        servicio.setNombreservicio(servicioDTO.getNombreservicio());
        servicio.setPrecio(servicioDTO.getPrecio());
        servicio.setPorcentajeEfecto(servicioDTO.getPorcentajeEfecto());
        servicio.setCiudad(ciudad);  // Asocia la ciudad
        return servicio;
    }
}
