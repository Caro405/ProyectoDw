package com.example.demo.Controller;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.Service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/ciudad")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    // ✅ Listar todas las ciudades (para Angular)
    @GetMapping("/list")
    public List<CiudadDTO> listarCiudades() {
        return ciudadService.listarCiudades();
    }

    // ✅ Ver detalles de una ciudad por ID (para Angular)
    @GetMapping("/{id}")
    public Optional<CiudadDTO> obtenerCiudad(@PathVariable Long id) {
        return ciudadService.obtenerCiudadPorId(id);
    }

    // ✅ Guardar ciudad (crear o actualizar desde Angular)
    @PostMapping("/save")
    public CiudadDTO guardarCiudad(@RequestBody CiudadDTO ciudadDTO) {
        return ciudadService.guardarCiudad(ciudadDTO); // debe retornar el objeto guardado
    }

    // ✅ Eliminar ciudad
    @DeleteMapping("/delete/{id}")
    public void eliminarCiudad(@PathVariable Long id) {
        ciudadService.eliminarCiudad(id);
    }
}
