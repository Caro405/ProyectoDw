package com.example.demo.Controller;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.Service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @GetMapping
    public List<CiudadDTO> getAllCiudades() {
        return ciudadService.getAllCiudades();
    }

    @GetMapping("/{id}")
    public CiudadDTO getCiudadById(@PathVariable Long id) {
        return ciudadService.getCiudadById(id);
    }

    @PostMapping
    public CiudadDTO createCiudad(@RequestBody CiudadDTO ciudadDTO) {
        return ciudadService.createCiudad(ciudadDTO);
    }

    @PutMapping("/{id}")
    public CiudadDTO updateCiudad(@PathVariable Long id, @RequestBody CiudadDTO ciudadDTO) {
        return ciudadService.updateCiudad(id, ciudadDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCiudad(@PathVariable Long id) {
        ciudadService.deleteCiudad(id);
    }
}
