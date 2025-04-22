package com.example.demo.Service;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.Mapper.CiudadMapper;
import com.example.demo.Repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    // Usar la instancia generada por MapStruct
    private final CiudadMapper ciudadMapper = CiudadMapper.INSTANCE;

    public List<CiudadDTO> listarCiudades() {
        return ciudadRepository.findAll().stream()
                .map(ciudad -> ciudadMapper.toDTO(ciudad)) // Usar la instancia generada
                .collect(Collectors.toList());
    }

    public Optional<CiudadDTO> obtenerCiudadPorId(Long id) {
        return ciudadRepository.findById(id)
                .map(ciudad -> ciudadMapper.toDTO(ciudad)); // Usar la instancia generada
    }

    public CiudadDTO guardarCiudad(CiudadDTO ciudadDTO) {
        var entidad = ciudadMapper.toEntity(ciudadDTO); // Usar la instancia generada
        var guardada = ciudadRepository.save(entidad);
        return ciudadMapper.toDTO(guardada); // Usar la instancia generada
    }

    public void eliminarCiudad(Long id) {
        ciudadRepository.deleteById(id);
    }
}
