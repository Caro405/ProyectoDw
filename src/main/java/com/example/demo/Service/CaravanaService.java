package com.example.demo.Service;

import com.example.demo.Model.Caravana;
import com.example.demo.Repository.CaravanaRepository;
import com.example.demo.Mapper.CaravanaMapper;
import com.example.demo.dto.CaravanaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaravanaService {

    @Autowired
    private CaravanaRepository caravanaRepository;

    @Autowired
    private CaravanaMapper caravanaMapper;

    public List<CaravanaDTO> getAll() {
        return caravanaRepository.findAll()
                .stream()
                .map(caravanaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CaravanaDTO getById(Long id) {
        return caravanaRepository.findById(id)
                .map(caravanaMapper::toDTO)
                .orElse(null);
    }

    public CaravanaDTO create(CaravanaDTO dto) {
        Caravana entity = caravanaMapper.toEntity(dto);
        Caravana saved = caravanaRepository.save(entity);
        return caravanaMapper.toDTO(saved);
    }

    public CaravanaDTO update(Long id, CaravanaDTO dto) {
        return caravanaRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(dto.getNombre());
                    existing.setVelocidad(dto.getVelocidad());
                    existing.setCargaActual(dto.getCargaActual());
                    existing.setCapacidadMaxCarga(dto.getCapacidadMaxCarga());
                    existing.setDinero(dto.getDinero());
                    existing.setPuntosVidaActual(dto.getPuntosVidaActual());
                    existing.setPuntosVidaMax(dto.getPuntosVidaMax());
                    existing.setGuardias(dto.isGuardias());
                    // No actualizamos relaciones aquí por simplicidad
                    Caravana updated = caravanaRepository.save(existing);
                    return caravanaMapper.toDTO(updated);
                }).orElse(null);
    }

    public void delete(Long id) {
        caravanaRepository.deleteById(id);
    }
}
