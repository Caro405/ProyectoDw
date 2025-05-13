package com.example.demo.Mapper;

import com.example.demo.Model.Rol;
import com.example.demo.dto.RolDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolMapper {

    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    RolDTO rolToRolDTO(Rol rol);

    Rol rolDTOToRol(RolDTO rolDTO);
}
