package com.example.demo.Service;

import com.example.demo.dto.CaravanaDTO;
import com.example.demo.Model.Caravana;
import com.example.demo.Model.Inventario;
import com.example.demo.Mapper.CaravanaMapper;
import com.example.demo.Mapper.InventarioMapper;
import com.example.demo.Repository.CaravanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaravanaService {

    @Autowired
    private CaravanaRepository caravanaRepository;

    @Autowired
    private CaravanaMapper caravanaMapper;  // Inyección del mapper

    @Autowired
    private InventarioMapper inventarioMapper;

    @Autowired
    private InventarioService inventarioService;

    // Método para obtener todas las caravanas
    public List<CaravanaDTO> getAllCaravanas() {
        List<Caravana> caravanas = caravanaRepository.findAll();
        return caravanaMapper.toDTOList(caravanas);  // Usar el mapper para convertir a DTO
    }

    // Método para obtener una caravana por su ID
    public CaravanaDTO getCaravanaById(Long id) {
        Optional<Caravana> caravanaOptional = caravanaRepository.findById(id);
        return caravanaOptional.map(caravanaMapper::toDTO).orElse(null);  // Retorna el DTO o null
    }

    // Método para crear una nueva caravana
    public CaravanaDTO createCaravana(CaravanaDTO caravanaDTO) {
        Caravana caravana = caravanaMapper.toEntity(caravanaDTO);

        // Crear el inventario relacionado
        Inventario inventario = inventarioMapper.toEntity(caravanaDTO.getInventarioDTO());
        caravana.setInventario(inventario);

        // Guardar la caravana
        caravana = caravanaRepository.save(caravana);

        return caravanaMapper.toDTO(caravana);  // Convertir la caravana guardada a DTO
    }

    // Método para actualizar una caravana
    public CaravanaDTO updateCaravana(Long id, CaravanaDTO caravanaDTO) {
        Optional<Caravana> caravanaOptional = caravanaRepository.findById(id);
        if (caravanaOptional.isPresent()) {
            Caravana caravana = caravanaOptional.get();
            // Actualizar los campos de la caravana con la información del DTO
            caravana.setNombre(caravanaDTO.getNombre());
            caravana.setVelocidad(caravanaDTO.getVelocidad());
            caravana.setCargaActual(caravanaDTO.getCargaActual());
            caravana.setCapacidadMaxCarga(caravanaDTO.getCapacidadMaxCarga());
            caravana.setDinero(caravanaDTO.getDinero());
            caravana.setPuntosVidaActual(caravanaDTO.getPuntosVidaActual());
            caravana.setPuntosVidaMax(caravanaDTO.getPuntosVidaMax());
            caravana.setGuardias(caravanaDTO.isGuardias());

            // Actualizar el inventario si se proporciona
            Inventario inventario = inventarioMapper.toEntity(caravanaDTO.getInventarioDTO());
            caravana.setInventario(inventario);

            // Guardar la caravana actualizada
            caravana = caravanaRepository.save(caravana);
            return caravanaMapper.toDTO(caravana);
        }
        return null;  // Si no existe la caravana, retornar null
    }

    // Método para eliminar una caravana
    public void deleteCaravana(Long id) {
        caravanaRepository.deleteById(id);  // Eliminar la caravana
    }
}
