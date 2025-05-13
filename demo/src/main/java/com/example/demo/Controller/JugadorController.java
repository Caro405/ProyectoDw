package com.example.demo.Controller;

import com.example.demo.dto.JugadorDTO;
import com.example.demo.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<JugadorDTO> getAllJugadores() {
        return jugadorService.getAllJugadores();
    }

    @GetMapping("/{id}")
    public JugadorDTO getJugadorById(@PathVariable Long id) {
        return jugadorService.getJugadorById(id);
    }

    @PostMapping
    public JugadorDTO createJugador(@RequestBody JugadorDTO jugadorDTO) {
        return jugadorService.createJugador(jugadorDTO);
    }

    @PutMapping("/{id}")
    public JugadorDTO updateJugador(@PathVariable Long id, @RequestBody JugadorDTO jugadorDTO) {
        return jugadorService.updateJugador(id, jugadorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable Long id) {
        jugadorService.deleteJugador(id);
    }
}
