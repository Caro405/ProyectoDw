package com.example.demo.Controller;

import com.example.demo.dto.DetalleVentaDTO;
import com.example.demo.Mapper.DetalleVentaMapper;
import com.example.demo.Model.DetalleVenta;
import com.example.demo.Repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private DetalleVentaMapper detalleVentaMapper;

    public List<DetalleVentaDTO> getAllDetalles() {
        List<DetalleVenta> detalles = detalleVentaRepository.findAll();
        return detalles.stream()
                .map(detalleVentaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DetalleVentaDTO getDetalleById(Long id) {
        DetalleVenta detalle = detalleVentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleVenta no encontrado con id: " + id));
        return detalleVentaMapper.toDTO(detalle);
    }

    public DetalleVentaDTO createDetalle(DetalleVentaDTO detalleDTO) {
        DetalleVenta detalle = detalleVentaMapper.toEntity(detalleDTO);
        DetalleVenta saved = detalleVentaRepository.save(detalle);
        return detalleVentaMapper.toDTO(saved);
    }

    public DetalleVentaDTO updateDetalle(Long id, DetalleVentaDTO detalleDTO) {
        DetalleVenta detalle = detalleVentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleVenta no encontrado con id: " + id));

        detalle.setCantidad(detalleDTO.getCantidad());
        detalle.setPrecioUnitario(detalleDTO.getPrecioUnitario());
        detalle.setProducto(detalleVentaMapper.mapProducto(detalleDTO.getProductoId()));
        // No actualizamos la venta aquí para evitar inconsistencias, se gestiona en VentaService

        DetalleVenta updated = detalleVentaRepository.save(detalle);
        return detalleVentaMapper.toDTO(updated);
    }

    public void deleteDetalle(Long id) {
        detalleVentaRepository.deleteById(id);
    }
}
