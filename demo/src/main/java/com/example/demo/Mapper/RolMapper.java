package com.example.demo.Mapper;

import com.example.demo.Model.JugadoresSesion;
import com.example.demo.Model.Rol;
import com.example.demo.dto.RolDTO;
import org.springframework.stereotype.Component;

@Component
public class RolMapper {

    // Convertir de Rol a RolDTO
    public RolDTO rolToRolDTO(Rol rol) {
        if (rol == null) {
            return null;
        }

        return new RolDTO(
            rol.getId(),
            rol.getRol(),
            rol.getJugadoresSesion() != null ? rol.getJugadoresSesion().getId() : null
        );
    }

    // Convertir de RolDTO a Rol
    public Rol rolDTOToRol(RolDTO rolDTO) {
        if (rolDTO == null) {
            return null;
        }

        // Crear un objeto JugadoresSesion si es necesario
        JugadoresSesion jugadoresSesion = new JugadoresSesion();
        jugadoresSesion.setId(rolDTO.getJugadoresSesionId());

        return new Rol(rolDTO.getRol(), jugadoresSesion);
    }
}
