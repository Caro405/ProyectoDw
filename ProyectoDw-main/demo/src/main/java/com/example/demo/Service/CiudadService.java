package com.example.demo.Service;

import com.example.demo.Model.Ciudad;
import com.example.demo.Repository.CiudadRepository;
import com.example.demo.dto.CiudadDTO;
import com.example.demo.Mapper.CiudadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CiudadService {

    private final CiudadRepository ciudadRepository;
    private final CiudadMapper ciudadMapper;

    //@Autowired
    public CiudadService(CiudadRepository ciudadRepository, CiudadMapper ciudadMapper) {
        this.ciudadRepository = ciudadRepository;
        this.ciudadMapper = ciudadMapper;
    }

    public List<CiudadDTO> findAll() {
        return ciudadRepository.findAll()
                .stream()
                .map(ciudadMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CiudadDTO> findById(Long id) {
        return ciudadRepository.findById(id)
                .map(ciudadMapper::toDTO);
    }

    public Ciudad getCiudadEntityById(Long id) {
        return ciudadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada con id: " + id));
    }

    public CiudadDTO save(CiudadDTO ciudadDTO) {
        Ciudad ciudad = ciudadMapper.toEntity(ciudadDTO);
        Ciudad savedCiudad = ciudadRepository.save(ciudad);
        return ciudadMapper.toDTO(savedCiudad);
    }

    public CiudadDTO update(Long id, CiudadDTO ciudadDTO) {
        if (!ciudadRepository.existsById(id)) {
            throw new RuntimeException("Ciudad no encontrada con id: " + id);
        }
        ciudadDTO.setId(id);
        Ciudad ciudad = ciudadMapper.toEntity(ciudadDTO);
        Ciudad updatedCiudad = ciudadRepository.save(ciudad);
        return ciudadMapper.toDTO(updatedCiudad);
    }

    public void deleteById(Long id) {
        if (!ciudadRepository.existsById(id)) {
            throw new RuntimeException("Ciudad no encontrada con id: " + id);
        }
        ciudadRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return ciudadRepository.existsById(id);
    }

}