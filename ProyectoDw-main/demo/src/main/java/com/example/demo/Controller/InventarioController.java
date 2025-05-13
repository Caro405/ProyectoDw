package com.example.demo.Controller;

import com.example.demo.dto.InventarioDTO;
import com.example.demo.Service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<InventarioDTO> getAllInventarios() {
        return inventarioService.getAllInventarios();
    }

    @GetMapping("/{id}")
    public InventarioDTO getInventarioById(@PathVariable Long id) {
        return inventarioService.getInventarioById(id);
    }

    @PostMapping
    public InventarioDTO createInventario(@RequestBody InventarioDTO inventarioDTO) {
        return inventarioService.createInventario(inventarioDTO);
    }

    @PutMapping("/{id}")
    public InventarioDTO updateInventario(@PathVariable Long id, @RequestBody InventarioDTO inventarioDTO) {
        return inventarioService.updateInventario(id, inventarioDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteInventario(@PathVariable Long id) {
        inventarioService.deleteInventario(id);
    }
}
