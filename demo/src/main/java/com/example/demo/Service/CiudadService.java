package com.example.demo.Service;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.Model.Ciudad;
import com.example.demo.Repository.CiudadRepository;
import com.example.demo.Mapper.CiudadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    private final CiudadMapper ciudadMapper = CiudadMapper.INSTANCE;

    // Obtener todas las ciudades
    public List<CiudadDTO> getAllCiudades() {
        List<Ciudad> ciudades = ciudadRepository.findAll();
        return ciudades.stream()
                .map(ciudadMapper::toDTO)  // Mapear Ciudad a CiudadDTO
                .collect(Collectors.toList());
    }

    // Obtener ciudad por ID
    public CiudadDTO getCiudadById(Long id) {
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        return ciudad.map(ciudadMapper::toDTO).orElseThrow();  // Lanzar excepción si no se encuentra
    }

    // Crear una nueva ciudad
    public CiudadDTO createCiudad(CiudadDTO ciudadDTO) {
        Ciudad ciudad = ciudadMapper.toEntity(ciudadDTO);
        Ciudad savedCiudad = ciudadRepository.save(ciudad);
        return ciudadMapper.toDTO(savedCiudad);  // Retornar el DTO de la ciudad guardada
    }

    // Actualizar ciudad existente
    public CiudadDTO updateCiudad(Long id, CiudadDTO ciudadDTO) {
        Optional<Ciudad> ciudadOpt = ciudadRepository.findById(id);
        if (!ciudadOpt.isPresent()) {
            throw new RuntimeException("Ciudad no encontrada");
        }

        Ciudad ciudad = ciudadOpt.get();
        ciudad.setNombre(ciudadDTO.getNombre());
        ciudad.setImpuestos(ciudadDTO.getImpuestos());

        Ciudad updatedCiudad = ciudadRepository.save(ciudad);
        return ciudadMapper.toDTO(updatedCiudad);  // Retornar el DTO actualizado
    }

    // Eliminar ciudad por ID
    public void deleteCiudad(Long id) {
        ciudadRepository.deleteById(id);
    }
}
