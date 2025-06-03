package com.example.demo.Service;

import com.example.demo.Model.*;
import com.example.demo.Repository.RutaRepository;
import com.example.demo.dto.RutaDTO;
import com.example.demo.Mapper.RutaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;
    
    @Autowired
    private RutaMapper rutaMapper;
    
    @Autowired
    private CiudadService ciudadService;

    public boolean existsById(Long id) {
    return rutaRepository.existsById(id);
}

public void deleteById(Long id) {
    rutaRepository.deleteById(id);
}

    public List<RutaDTO> findAll() {
        return rutaRepository.findAll()
                .stream()
                .map(rutaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<RutaDTO> findById(Long id) {
        return rutaRepository.findById(id)
                .map(rutaMapper::toDTO);
    }

    public RutaDTO save(RutaDTO rutaDTO) {
        Ciudad origen = ciudadService.getCiudadEntityById(rutaDTO.getCiudadOrigenId());
        Ciudad destino = ciudadService.getCiudadEntityById(rutaDTO.getCiudadDestinoId());
        
        Ruta ruta = rutaMapper.toEntityWithCiudades(rutaDTO, origen, destino);
        Ruta savedRuta = rutaRepository.save(ruta);
        return rutaMapper.toDTO(savedRuta);
    }
}