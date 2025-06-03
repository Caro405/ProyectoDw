package com.example.demo.Controller;

import com.example.demo.dto.JugadorDTO;
import com.example.demo.Service.JugadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<JugadorDTO> getAll() {
        return jugadorService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorDTO> getById(@PathVariable Long id) {
        JugadorDTO dto = jugadorService.getById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public JugadorDTO create(@RequestBody JugadorDTO dto) {
        return jugadorService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JugadorDTO> update(@PathVariable Long id, @RequestBody JugadorDTO dto) {
        JugadorDTO updated = jugadorService.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jugadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
