package com.example.demo.Controller;

import com.example.demo.dto.ServicioDTO;
import com.example.demo.Service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public List<ServicioDTO> getAllServicios() {
        return servicioService.getAllServicios();
    }

    @GetMapping("/{id}")
    public ServicioDTO getServicioById(@PathVariable Long id) {
        return servicioService.obtenerServicioPorId(id);
    }

    @PostMapping
    public void createServicio(@RequestBody ServicioDTO servicioDTO) {
        servicioService.guardarServicio(servicioDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteServicio(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
    }
}
