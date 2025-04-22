package com.example.demo.Service;

import com.example.demo.dto.CaravanaDTO;
import com.example.demo.Mapper.CaravanaMapper;
import com.example.demo.Repository.CaravanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Service.JugadorService;
import com.example.demo.Service.ProductoService;
import com.example.demo.Service.CiudadService;
import com.example.demo.Service.RutaService;
import com.example.demo.Service.ServicioService;
import com.example.demo.Model.Jugador;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CaravanaService {

    @Autowired
    private CaravanaRepository caravanaRepository;

    // Listar todas las caravanas
    public List<CaravanaDTO> listarCaravanas() {
        return caravanaRepository.findAll().stream()
                .map(CaravanaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener una caravana por su ID
    public Optional<CaravanaDTO> obtenerCaravanaPorId(Long id) {
        return caravanaRepository.findById(id)
                .map(CaravanaMapper::toDTO);
    }

    // Guardar una nueva caravana
    public void guardarCaravana(CaravanaDTO caravanaDTO) {
        caravanaRepository.save(CaravanaMapper.toEntity(caravanaDTO));
    }

    // Eliminar una caravana por su ID
    public void eliminarCaravana(Long id) {
        caravanaRepository.deleteById(id);
    }
}
