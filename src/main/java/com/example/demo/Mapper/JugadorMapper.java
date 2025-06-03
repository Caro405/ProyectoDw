package com.example.demo.Mapper;

import com.example.demo.Model.*;
import com.example.demo.dto.JugadorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {RolMapper.class})
public interface JugadorMapper {

    @Mapping(source = "caravana.id", target = "caravanaId")
    @Mapping(source = "roles", target = "rolesIds", qualifiedByName = "rolesToIds")
    JugadorDTO toDTO(Jugador entity);

    @Mapping(source = "caravanaId", target = "caravana")
    @Mapping(source = "rolesIds", target = "roles", qualifiedByName = "idsToRoles")
    Jugador toEntity(JugadorDTO dto);

    @Named("rolesToIds")
    default List<Long> rolesToIds(List<JugadorRol> roles) {
        if (roles == null) return null;
        return roles.stream()
                .map(r -> r.getRol().getId())
                .collect(Collectors.toList());
    }

    @Named("idsToRoles")
    default List<JugadorRol> idsToRoles(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream().map(id -> {
            JugadorRol jr = new JugadorRol();
            Rol r = new Rol();
            r.setId(id);
            jr.setRol(r);
            return jr;
        }).collect(Collectors.toList());
    }

    default Caravana mapCaravana(Long id) {
        if (id == null) return null;
        Caravana c = new Caravana();
        c.setId(id);
        return c;
    }
}