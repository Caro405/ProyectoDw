package com.example.demo.Service;

import com.example.demo.dto.VentaDTO;
import com.example.demo.Mapper.VentaMapper;
import com.example.demo.Model.Venta;
import com.example.demo.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VentaMapper ventaMapper;

    public List<VentaDTO> getAllVentas() {
        List<Venta> ventas = ventaRepository.findAll();
        return ventas.stream()
                .map(ventaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VentaDTO getVentaById(Long id) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con id: " + id));
        return ventaMapper.toDTO(venta);
    }

    public VentaDTO createVenta(VentaDTO ventaDTO) {
        Venta venta = ventaMapper.toEntity(ventaDTO);
        if (venta.getDetalles() != null) {
            venta.getDetalles().forEach(detalle -> detalle.setVenta(venta));
        }
        Venta saved = ventaRepository.save(venta);
        return ventaMapper.toDTO(saved);
    }

    public VentaDTO updateVenta(Long id, VentaDTO ventaDTO) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con id: " + id));

        venta.setCaravana(ventaMapper.mapCaravana(ventaDTO.getCaravanaId()));
        venta.setCiudad(ventaMapper.mapCiudad(ventaDTO.getCiudadId()));
        venta.setFecha(ventaDTO.getFechaVenta());
        venta.setTotal(ventaDTO.getTotal());
        // Para detalles: actualizar según lógica específica (no incluido aquí)

        Venta updated = ventaRepository.save(venta);
        return ventaMapper.toDTO(updated);
    }

    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}

