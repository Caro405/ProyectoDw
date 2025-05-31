package com.example.demo.Controller;

import com.example.demo.dto.CaravanaDTO;
import com.example.demo.Service.CaravanaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caravanas")
public class CaravanaController {

    @Autowired
    private CaravanaService caravanaService;

    @GetMapping
    public List<CaravanaDTO> getAll() {
        return caravanaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaravanaDTO> getById(@PathVariable Long id) {
        CaravanaDTO dto = caravanaService.getById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public CaravanaDTO create(@RequestBody CaravanaDTO dto) {
        return caravanaService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaravanaDTO> update(@PathVariable Long id, @RequestBody CaravanaDTO dto) {
        CaravanaDTO updated = caravanaService.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        caravanaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
