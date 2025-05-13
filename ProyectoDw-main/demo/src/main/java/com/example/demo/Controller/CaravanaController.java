package com.example.demo.Controller;

import com.example.demo.dto.CaravanaDTO;
import com.example.demo.Service.CaravanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caravanas")
public class CaravanaController {

    @Autowired
    private CaravanaService caravanaService;

    @GetMapping
    public List<CaravanaDTO> getAllCaravanas() {
        return caravanaService.getAllCaravanas();
    }

    @GetMapping("/{id}")
    public CaravanaDTO getCaravanaById(@PathVariable Long id) {
        return caravanaService.getCaravanaById(id);
    }

    @PostMapping
    public CaravanaDTO createCaravana(@RequestBody CaravanaDTO caravanaDTO) {
        return caravanaService.createCaravana(caravanaDTO);
    }

    @PutMapping("/{id}")
    public CaravanaDTO updateCaravana(@PathVariable Long id, @RequestBody CaravanaDTO caravanaDTO) {
        return caravanaService.updateCaravana(id, caravanaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCaravana(@PathVariable Long id) {
        caravanaService.deleteCaravana(id);
    }
}
