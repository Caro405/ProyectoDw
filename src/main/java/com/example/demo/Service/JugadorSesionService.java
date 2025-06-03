package com.example.demo.Service;

import com.example.demo.Model.JugadorSesion;
import com.example.demo.Repository.JugadorSesionRepository;
import com.example.demo.Mapper.JugadorSesionMapper;
import com.example.demo.dto.JugadorSesionDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JugadorSesionService {

    @Autowired
    private JugadorSesionRepository jugadorSesionRepository;

    @Autowired
    private JugadorSesionMapper mapper;

    public List<JugadorSesionDTO> getAll() {
        return jugadorSesionRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public JugadorSesionDTO getById(Long id) {
        return jugadorSesionRepository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    public JugadorSesionDTO create(JugadorSesionDTO dto) {
        JugadorSesion entity = mapper.toEntity(dto);
        JugadorSesion saved = jugadorSesionRepository.save(entity);
        return mapper.toDTO(saved);
    }

    public JugadorSesionDTO update(Long id, JugadorSesionDTO dto) {
        return jugadorSesionRepository.findById(id)
                .map(existing -> {
                    // Puedes actualizar los campos que necesites aquí
                    JugadorSesion updated = jugadorSesionRepository.save(existing);
                    return mapper.toDTO(updated);
                }).orElse(null);
    }

    public void delete(Long id) {
        jugadorSesionRepository.deleteById(id);
    }
}
