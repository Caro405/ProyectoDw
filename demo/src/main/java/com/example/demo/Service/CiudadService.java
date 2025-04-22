package com.example.demo.Service;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.Mapper.CiudadMapper;
import com.example.demo.Repository.CiudadRepository;
import com.example.demo.Repository.ProductoRepository; // Añadir el repositorio de productos
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private ProductoRepository productoRepository;  // Añadir el repositorio de productos

    // Usar la instancia generada por MapStruct
    private final CiudadMapper ciudadMapper = CiudadMapper.INSTANCE;

    public List<CiudadDTO> listarCiudades() {
        return ciudadRepository.findAll().stream()
                .map(ciudad -> {
                    // Obtener productos de la ciudad y mapearlos a ProductoDTO
                    List<ProductoDTO> productos = productoRepository.findByCiudadId(ciudad.getId()).stream()
                            .map(producto -> new ProductoDTO(
                                    producto.getId(),
                                    producto.getNombre(),
                                    producto.getCategoria().toString(),
                                    producto.getPrecioBase()
                            ))
                            .collect(Collectors.toList());

                    // Mapear la ciudad a DTO e incluir los productos
                    CiudadDTO ciudadDTO = ciudadMapper.toDTO(ciudad);
                    ciudadDTO.setProductos(productos);
                    return ciudadDTO;
                })
                .collect(Collectors.toList());
    }

    public Optional<CiudadDTO> obtenerCiudadPorId(Long id) {
        return ciudadRepository.findById(id)
                .map(ciudad -> {
                    List<ProductoDTO> productos = productoRepository.findByCiudadId(ciudad.getId()).stream()
                            .map(producto -> new ProductoDTO(
                                    producto.getId(),
                                    producto.getNombre(),
                                    producto.getCategoria().toString(),
                                    producto.getPrecioBase()
                            ))
                            .collect(Collectors.toList());

                    CiudadDTO ciudadDTO = ciudadMapper.toDTO(ciudad);
                    ciudadDTO.setProductos(productos);
                    return ciudadDTO;
                });
    }

    public CiudadDTO guardarCiudad(CiudadDTO ciudadDTO) {
        var entidad = ciudadMapper.toEntity(ciudadDTO);
        var guardada = ciudadRepository.save(entidad);
        return ciudadMapper.toDTO(guardada);
    }

    public void eliminarCiudad(Long id) {
        ciudadRepository.deleteById(id);
    }
}
