package com.example.demo.Service;

import com.example.demo.dto.InventarioProductoDTO;
import com.example.demo.Model.InventarioProducto;
import com.example.demo.Repository.InventarioProductoRepository;
import com.example.demo.Mapper.InventarioProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventarioProductoService {

    @Autowired
    private InventarioProductoRepository inventarioProductoRepository;

    public List<InventarioProductoDTO> getAllInventarioProductos() {
        List<InventarioProducto> inventarioProductos = inventarioProductoRepository.findAll();
        return inventarioProductos.stream()
                .map(InventarioProductoMapper.INSTANCE::inventarioProductoToInventarioProductoDTO)
                .collect(Collectors.toList());
    }

    public InventarioProductoDTO getInventarioProductoById(Long id) {
        InventarioProducto inventarioProducto = inventarioProductoRepository.findById(id).orElseThrow();
        return InventarioProductoMapper.INSTANCE.inventarioProductoToInventarioProductoDTO(inventarioProducto);
    }

    public InventarioProductoDTO createInventarioProducto(InventarioProductoDTO inventarioProductoDTO) {
        InventarioProducto inventarioProducto = InventarioProductoMapper.INSTANCE.inventarioProductoDTOToInventarioProducto(inventarioProductoDTO);
        inventarioProductoRepository.save(inventarioProducto);
        return InventarioProductoMapper.INSTANCE.inventarioProductoToInventarioProductoDTO(inventarioProducto);
    }

    public InventarioProductoDTO updateInventarioProducto(Long id, InventarioProductoDTO inventarioProductoDTO) {
        InventarioProducto inventarioProducto = inventarioProductoRepository.findById(id).orElseThrow();
        inventarioProducto.setCantidad(inventarioProductoDTO.getCantidad());
        inventarioProductoRepository.save(inventarioProducto);
        return InventarioProductoMapper.INSTANCE.inventarioProductoToInventarioProductoDTO(inventarioProducto);
    }

    public void deleteInventarioProducto(Long id) {
        inventarioProductoRepository.deleteById(id);
    }
}
