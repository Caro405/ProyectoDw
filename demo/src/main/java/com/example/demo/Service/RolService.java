package com.example.demo.Service;

import com.example.demo.dto.RolDTO;
import com.example.demo.Model.Rol;
import com.example.demo.Repository.RolRepository;
import com.example.demo.Mapper.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<RolDTO> getAllRoles() {
        List<Rol> roles = rolRepository.findAll();
        return roles.stream()
                .map(RolMapper.INSTANCE::rolToRolDTO)
                .collect(Collectors.toList());
    }

    public RolDTO getRolById(Long id) {
        Rol rol = rolRepository.findById(id).orElseThrow();
        return RolMapper.INSTANCE.rolToRolDTO(rol);
    }

    public RolDTO createRol(RolDTO rolDTO) {
        Rol rol = RolMapper.INSTANCE.rolDTOToRol(rolDTO);
        rolRepository.save(rol);
        return RolMapper.INSTANCE.rolToRolDTO(rol);
    }

    public RolDTO updateRol(Long id, RolDTO rolDTO) {
        Rol rol = rolRepository.findById(id).orElseThrow();
        rol.setRol(rolDTO.getRol());
        rolRepository.save(rol);
        return RolMapper.INSTANCE.rolToRolDTO(rol);
    }

    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }
}
