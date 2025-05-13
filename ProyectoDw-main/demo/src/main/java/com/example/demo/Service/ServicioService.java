package com.example.demo.Service;

import com.example.demo.dto.ServicioDTO;
import com.example.demo.Model.Servicio;
import com.example.demo.Repository.ServicioRepository;
import com.example.demo.Mapper.ServicioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    private final ServicioMapper servicioMapper = ServicioMapper.INSTANCE;

    // Obtener todos los servicios
    public List<ServicioDTO> getAllServicios() {
        List<Servicio> servicios = servicioRepository.findAll();
        return servicios.stream()
                .map(servicioMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener servicio por ID
    public ServicioDTO obtenerServicioPorId(Long id) {
        Servicio servicio = servicioRepository.findById(id).orElseThrow();
        return servicioMapper.toDTO(servicio);
    }

    // Guardar un nuevo servicio
    public ServicioDTO guardarServicio(ServicioDTO servicioDTO) {
        Servicio servicio = servicioMapper.toEntity(servicioDTO);
        Servicio savedServicio = servicioRepository.save(servicio);
        return servicioMapper.toDTO(savedServicio);
    }

    // Eliminar servicio por ID
    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}
