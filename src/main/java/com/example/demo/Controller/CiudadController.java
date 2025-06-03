package com.example.demo.Controller;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.Service.CiudadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    // Obtener todas las ciudades
    @GetMapping
    public ResponseEntity<List<CiudadDTO>> getAllCiudades() {
        List<CiudadDTO> ciudades = ciudadService.findAll();
        return ResponseEntity.ok(ciudades);
    }

    // Obtener una ciudad por ID
    @GetMapping("/{id}")
    public ResponseEntity<CiudadDTO> getCiudadById(@PathVariable Long id) {
        return ciudadService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva ciudad
    @PostMapping
    public ResponseEntity<CiudadDTO> createCiudad(@RequestBody CiudadDTO ciudadDTO) {
        CiudadDTO nuevaCiudad = ciudadService.save(ciudadDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCiudad);
    }

    // Actualizar una ciudad existente
    @PutMapping("/{id}")
    public ResponseEntity<CiudadDTO> updateCiudad(@PathVariable Long id, @RequestBody CiudadDTO ciudadDTO) {
        if (!ciudadService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ciudadDTO.setId(id);
        CiudadDTO updatedCiudad = ciudadService.update(id, ciudadDTO);
        return ResponseEntity.ok(updatedCiudad);
    }

    // Eliminar una ciudad
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCiudad(@PathVariable Long id) {
        if (!ciudadService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ciudadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
