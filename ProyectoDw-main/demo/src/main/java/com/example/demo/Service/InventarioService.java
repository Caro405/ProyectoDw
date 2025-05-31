package com.example.demo.Service;

import com.example.demo.dto.InventarioDTO;
import com.example.demo.Model.Inventario;
import com.example.demo.Repository.InventarioRepository;
import com.example.demo.Mapper.InventarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    private final InventarioMapper inventarioMapper;

    // Inyección por constructor (recomendado)
    public InventarioService(InventarioMapper inventarioMapper) {
        this.inventarioMapper = inventarioMapper;
    }

    // Obtener todos los inventarios
    public List<InventarioDTO> getAllInventarios() {
        List<Inventario> inventarios = inventarioRepository.findAll();
        return inventarios.stream()
                .map(inventarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener un inventario por ID
    public InventarioDTO getInventarioById(Long id) {
        Inventario inventario = inventarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Inventario no encontrado con id: " + id));
        return inventarioMapper.toDTO(inventario);
    }

    // Crear un nuevo inventario
    public InventarioDTO createInventario(InventarioDTO inventarioDTO) {
        Inventario inventario = inventarioMapper.toEntity(inventarioDTO);
        Inventario savedInventario = inventarioRepository.save(inventario);
        return inventarioMapper.toDTO(savedInventario);
    }

    // Actualizar un inventario existente
    public InventarioDTO updateInventario(Long id, InventarioDTO inventarioDTO) {
        Inventario inventario = inventarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Inventario no encontrado con id: " + id));
        
        inventario.setNombre(inventarioDTO.getNombre());
        // Si deseas actualizar caravana, productosInventario, serviciosInventario, agregalos aquí
        // Por ejemplo, actualizar caravana:
        // inventario.setCaravana(inventarioMapper.map(inventarioDTO.getCaravanaId()));
        
        inventarioRepository.save(inventario);
        return inventarioMapper.toDTO(inventario);
    }

    // Eliminar un inventario
    public void deleteInventario(Long id) {
        if (!inventarioRepository.existsById(id)) {
            throw new RuntimeException("Inventario no encontrado con id: " + id);
        }
        inventarioRepository.deleteById(id);
    }
}
