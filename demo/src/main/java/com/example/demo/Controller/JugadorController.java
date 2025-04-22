package com.example.demo.Controller;

import com.example.demo.Service.JugadorService;
import com.example.demo.dto.JugadorDTO;
import com.example.demo.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/jugador")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    private Logger log = LoggerFactory.getLogger(getClass()); // Logger para los logs

    // Listar todos los jugadores
    @GetMapping("/list")
    public List<JugadorDTO> listarJugadores() {
        return jugadorService.listarJugadores();  // Sin paginación, retorna la lista completa
    }

    // Listar jugadores con paginación
    @GetMapping("/list/{page}")
    public ResponseEntity<?> listarJugadores(@PathVariable Integer page) {
        if (page >= 0) {  // Asegurarse de que la página no sea negativa
            Page<JugadorDTO> jugadoresPage = jugadorService.listaJugador(PageRequest.of(page, 10));  // Usar paginación
            return ResponseEntity.ok(jugadoresPage.getContent());  // Retorna la lista de jugadores de la página solicitada
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("Page numbers cannot be negative"));
        }
    }

    // Buscar jugadores por nombre
    @GetMapping("/search")
    public List<JugadorDTO> buscarJugadores(@RequestParam(required = false) String searchText) {
        if (searchText == null || searchText.trim().equals("")) {
            return jugadorService.listarJugadores();  // Si no se especifica búsqueda, retornar todos
        } else {
            return jugadorService.buscarJugadoresPorNombre(searchText);  // Buscar jugadores por nombre
        }
    }

    // Buscar jugador por ID
    @GetMapping("/{idJugador}")
    public ResponseEntity<JugadorDTO> buscarJugador(@PathVariable("idJugador") Long id) {
        return jugadorService.buscarJugador(id)
                .map(jugadorDTO -> ResponseEntity.ok(jugadorDTO))
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }

    // Crear un jugador
    @PostMapping
    public JugadorDTO crearJugador(@RequestBody JugadorDTO jugadorDTO) {
        return jugadorService.crearJugador(jugadorDTO);
    }

    // Actualizar un jugador
    @PutMapping
    public JugadorDTO actualizarJugador(@RequestBody JugadorDTO jugadorDTO) {
        return jugadorService.actualizarJugador(jugadorDTO);
    }

    // Eliminar un jugador
    @DeleteMapping("/{id}")
    public void borrarJugador(@PathVariable Long id) {
        jugadorService.borrarJugador(id);
    }
}
