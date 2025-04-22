package com.example.demo.Controller;

import com.example.demo.Service.CiudadService;
import com.example.demo.dto.CiudadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.example.demo.Model.Jugador;

import java.util.List;  // Importa List correctamente
import java.util.Optional;  // Importa Optional correctamente

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/ciudad")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    // ✅ Listar todas las ciudades (para Angular)
    @GetMapping("/list")
    public ResponseEntity<List<CiudadDTO>> listarCiudades() {
        List<CiudadDTO> ciudades = ciudadService.listarCiudades();
        if (ciudades.isEmpty()) {
            return ResponseEntity.noContent().build(); // Si no hay ciudades, retorna un 204 No Content
        }
        return ResponseEntity.ok(ciudades); // Retorna un 200 OK con la lista de ciudades
    }

    // ✅ Ver detalles de una ciudad por ID (para Angular)
    @GetMapping("/{id}")
    public ResponseEntity<CiudadDTO> obtenerCiudad(@PathVariable Long id) {
        Optional<CiudadDTO> ciudad = ciudadService.obtenerCiudadPorId(id);
        return ciudad.map(ResponseEntity::ok)  // Si la ciudad existe, retorna un 200 OK con la ciudad
                     .orElseGet(() -> ResponseEntity.notFound().build()); // Si no se encuentra, retorna un 404 Not Found
    }

    // ✅ Guardar ciudad (crear o actualizar desde Angular)
    @PostMapping("/save")
    public ResponseEntity<CiudadDTO> guardarCiudad(@RequestBody CiudadDTO ciudadDTO) {
        CiudadDTO ciudadGuardada = ciudadService.guardarCiudad(ciudadDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ciudadGuardada); // Retorna un 201 Created con la ciudad guardada
    }

    // ✅ Eliminar ciudad
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarCiudad(@PathVariable Long id) {
        try {
            ciudadService.eliminarCiudad(id);
            return ResponseEntity.noContent().build(); // Retorna un 204 No Content si la eliminación fue exitosa
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Si no encuentra la ciudad, retorna un 404 Not Found
        }
    }
}
