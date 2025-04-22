package com.example.demo.Service;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.Mapper.CiudadMapper;
import com.example.demo.Repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Jugador;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public List<CiudadDTO> listarCiudades() {
        return ciudadRepository.findAll().stream()
                .map(CiudadMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CiudadDTO> obtenerCiudadPorId(Long id) {
        return ciudadRepository.findById(id)
                .map(CiudadMapper::toDTO);
    }

    public CiudadDTO guardarCiudad(CiudadDTO ciudadDTO) {
        var entidad = CiudadMapper.toEntity(ciudadDTO);          // convierte el DTO en entidad
        var guardada = ciudadRepository.save(entidad);           // guarda y devuelve la entidad con ID generado
        return CiudadMapper.toDTO(guardada);                     // convierte de nuevo a DTO
    }
    

    public void eliminarCiudad(Long id) {
        ciudadRepository.deleteById(id);
    }
}
