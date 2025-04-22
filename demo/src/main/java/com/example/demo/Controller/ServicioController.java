package com.example.demo.Controller;

import com.example.demo.Service.ServicioService;
import com.example.demo.dto.ServicioDTO;
import com.example.demo.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    // Listar todos los servicios sin paginación
    @GetMapping("/list")
    public List<ServicioDTO> listarServicios() {
        return servicioService.listarServicios();
    }

    // Listar servicios con paginación
    @GetMapping("/list/{page}")
    public ResponseEntity<?> listarServicios(@PathVariable Integer page) {
        if (page >= 0) {
            // Usamos PageRequest para la paginación
            Pageable pageable = PageRequest.of(page, 10);
            return ResponseEntity.ok(servicioService.listarServicios(pageable).getContent());
        } else {
            // Manejo de error si el número de página es negativo
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("Page numbers cannot be negative"));
        }
    }

    // Buscar un servicio por su ID
    @GetMapping("/{idServicio}")
    public ResponseEntity<ServicioDTO> buscarServicio(@PathVariable Long idServicio) {
        return servicioService.obtenerServicioPorId(idServicio)
                .map(servicioDTO -> ResponseEntity.ok(servicioDTO))
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
    }

    // Crear un nuevo servicio
    @PostMapping
    public ServicioDTO crearServicio(@RequestBody ServicioDTO servicioDTO) {
        servicioService.guardarServicio(servicioDTO);
        return servicioDTO;
    }

    // Eliminar un servicio
    @DeleteMapping("/{id}")
    public void borrarServicio(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
    }
}
