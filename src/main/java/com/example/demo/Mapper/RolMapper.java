package com.example.demo.Mapper;

import com.example.demo.Model.Rol;
import com.example.demo.dto.RolDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {

    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    RolDTO toDTO(Rol entity);

    Rol toEntity(RolDTO dto);

    List<RolDTO> toDTOList(List<Rol> entities);
}
