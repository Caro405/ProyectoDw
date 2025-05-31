package com.example.demo.Service;

import com.example.demo.Model.Rol;
import com.example.demo.Model.RolTipo;
import com.example.demo.Repository.RolRepository;
import com.example.demo.dto.RolDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    // Obtener todos los roles como DTOs
    public List<RolDTO> getAllRoles() {
        List<Rol> roles = rolRepository.findAll();
        return roles.stream()
                .map(rol -> new RolDTO(rol.getId(), rol.getRolTipo().name()))
                .collect(Collectors.toList());
    }

    // Buscar Rol por ID
    public RolDTO getRolById(Long id) {
        Rol rol = rolRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        return new RolDTO(rol.getId(), rol.getRolTipo().name());
    }

    // Crear un nuevo rol
    public RolDTO createRol(String rolTipoStr) {
        RolTipo rolTipo = RolTipo.valueOf(rolTipoStr.toUpperCase());
        Rol rol = new Rol(rolTipo);
        Rol saved = rolRepository.save(rol);
        return new RolDTO(saved.getId(), saved.getRolTipo().name());
    }

    // Actualizar rol (solo rolTipo)
    public RolDTO updateRol(Long id, String rolTipoStr) {
        Rol rol = rolRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        rol.setRolTipo(RolTipo.valueOf(rolTipoStr.toUpperCase()));
        Rol updated = rolRepository.save(rol);
        return new RolDTO(updated.getId(), updated.getRolTipo().name());
    }

    // Eliminar rol por ID
    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }
}
