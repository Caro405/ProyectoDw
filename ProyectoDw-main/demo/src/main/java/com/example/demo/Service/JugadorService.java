package com.example.demo.Service;

import com.example.demo.Model.Jugador;
import com.example.demo.Repository.JugadorRepository;
import com.example.demo.Mapper.JugadorMapper;
import com.example.demo.dto.JugadorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private JugadorMapper jugadorMapper;

    public List<JugadorDTO> getAll() {
        return jugadorRepository.findAll()
                .stream()
                .map(jugadorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public JugadorDTO getById(Long id) {
        return jugadorRepository.findById(id)
                .map(jugadorMapper::toDTO)
                .orElse(null);
    }

    public JugadorDTO create(JugadorDTO dto) {
        Jugador entity = jugadorMapper.toEntity(dto);
        // Aquí podrías buscar y setear la caravana si quieres
        Jugador saved = jugadorRepository.save(entity);
        return jugadorMapper.toDTO(saved);
    }

    public JugadorDTO update(Long id, JugadorDTO dto) {
        return jugadorRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(dto.getNombre());
                    // No actualizar relaciones por simplicidad
                    Jugador updated = jugadorRepository.save(existing);
                    return jugadorMapper.toDTO(updated);
                }).orElse(null);
    }

    public void delete(Long id) {
        jugadorRepository.deleteById(id);
    }
}
