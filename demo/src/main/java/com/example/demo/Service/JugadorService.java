package com.example.demo.Service;

import com.example.demo.Model.Jugador;
import com.example.demo.Repository.JugadorRepository;
import com.example.demo.dto.JugadorDTO;
import com.example.demo.Mapper.JugadorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private JugadorMapper jugadorMapper;

    // Obtener todos los jugadores
    public List<JugadorDTO> obtenerTodosLosJugadores() {
        List<Jugador> jugadores = jugadorRepository.findAll();
        return jugadores.stream()
                .map(jugadorMapper::jugadorToJugadorDTO)
                .toList();
    }

    // Obtener jugador por ID
    public JugadorDTO obtenerJugadorPorId(Long id) {
        Optional<Jugador> jugadorOptional = jugadorRepository.findById(id);
        if (jugadorOptional.isPresent()) {
            return jugadorMapper.jugadorToJugadorDTO(jugadorOptional.get());
        }
        return null; // O lanzar excepción personalizada
    }

    // Crear un nuevo jugador
    public JugadorDTO crearJugador(JugadorDTO jugadorDTO) {
        Jugador jugador = jugadorMapper.jugadorDTOToJugador(jugadorDTO);
        Jugador jugadorGuardado = jugadorRepository.save(jugador);
        return jugadorMapper.jugadorToJugadorDTO(jugadorGuardado);
    }

    // Actualizar un jugador existente
    public JugadorDTO actualizarJugador(Long id, JugadorDTO jugadorDTO) {
        Optional<Jugador> jugadorOptional = jugadorRepository.findById(id);
        if (jugadorOptional.isPresent()) {
            Jugador jugador = jugadorOptional.get();
            jugador.setNombre(jugadorDTO.getNombre());  // Actualizamos el nombre o otros campos si es necesario
            Jugador jugadorActualizado = jugadorRepository.save(jugador);
            return jugadorMapper.jugadorToJugadorDTO(jugadorActualizado);
        }
        return null; // O lanzar excepción personalizada
    }

    // Eliminar un jugador por ID
    public boolean eliminarJugador(Long id) {
        Optional<Jugador> jugadorOptional = jugadorRepository.findById(id);
        if (jugadorOptional.isPresent()) {
            jugadorRepository.delete(jugadorOptional.get());
            return true;
        }
        return false; // O lanzar excepción personalizada
    }
}
