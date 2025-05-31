package com.example.demo.Controller;

import com.example.demo.dto.VentaDTO;
import com.example.demo.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<VentaDTO> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{id}")
    public VentaDTO getVentaById(@PathVariable Long id) {
        return ventaService.getVentaById(id);
    }

    @PostMapping
    public VentaDTO createVenta(@RequestBody VentaDTO ventaDTO) {
        return ventaService.createVenta(ventaDTO);
    }

    @PutMapping("/{id}")
    public VentaDTO updateVenta(@PathVariable Long id, @RequestBody VentaDTO ventaDTO) {
        return ventaService.updateVenta(id, ventaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
    }
}

