package com.example.demo.Controller;

import com.example.demo.dto.RutaDTO;
import com.example.demo.Service.RutaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutas")
public class RutaController {

    private final RutaService rutaService;

 //   @Autowired
    public RutaController(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    @GetMapping
    public ResponseEntity<List<RutaDTO>> getAllRutas() {
        List<RutaDTO> rutas = rutaService.findAll();
        return new ResponseEntity<>(rutas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaDTO> getRutaById(@PathVariable Long id) {
        return rutaService.findById(id)
                .map(ruta -> new ResponseEntity<>(ruta, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<RutaDTO> createRuta(@RequestBody RutaDTO rutaDTO) {
        RutaDTO nuevaRuta = rutaService.save(rutaDTO);
        return new ResponseEntity<>(nuevaRuta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutaDTO> updateRuta(@PathVariable Long id, @RequestBody RutaDTO rutaDTO) {
        if (!rutaService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rutaDTO.setId(id); // Asegurar que el ID coincida
        RutaDTO updatedRuta = rutaService.save(rutaDTO);
        return new ResponseEntity<>(updatedRuta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuta(@PathVariable Long id) {
        if (!rutaService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rutaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}