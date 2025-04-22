package com.example.demo.Service;

import com.example.demo.dto.ServicioDTO;
import com.example.demo.Mapper.ServicioMapper;
import com.example.demo.Model.Servicio;
import com.example.demo.Repository.ServicioRepository;
import com.example.demo.Repository.CiudadRepository;
import com.example.demo.Model.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    // Listar todos los servicios sin paginación
    public List<ServicioDTO> listarServicios() {
        return servicioRepository.findAll().stream()
                .map(ServicioMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Listar servicios con paginación
    public Page<ServicioDTO> listarServicios(Pageable pageable) {
        return servicioRepository.findAll(pageable)
                .map(ServicioMapper::toDTO);  // Convertir la página de entidades a DTOs
    }

    // Obtener un servicio por su ID
    public Optional<ServicioDTO> obtenerServicioPorId(Long id) {
        return servicioRepository.findById(id).map(ServicioMapper::toDTO);
    }

    // Guardar un nuevo servicio
    public void guardarServicio(ServicioDTO servicioDTO) {
        Ciudad ciudad = ciudadRepository.findById(servicioDTO.getCiudadId()).orElseThrow();
        Servicio servicio = ServicioMapper.toEntity(servicioDTO, ciudad);
        servicioRepository.save(servicio);
    }

    // Eliminar un servicio por ID
    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}
