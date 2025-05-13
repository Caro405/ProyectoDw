package com.example.demo.Service;

import com.example.demo.dto.JugadorDTO;
import com.example.demo.Model.Jugador;
import com.example.demo.Repository.JugadorRepository;
import com.example.demo.Mapper.JugadorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    // Obtener todos los jugadores
    public List<JugadorDTO> getAllJugadores() {
        List<Jugador> jugadores = jugadorRepository.findAll();
        return jugadores.stream()
                .map(JugadorMapper.INSTANCE::jugadorToJugadorDTO) // Usamos el Mapper para convertir la entidad a DTO
                .collect(Collectors.toList());
    }

    // Obtener jugador por ID
    public JugadorDTO getJugadorById(Long id) {
        Jugador jugador = jugadorRepository.findById(id).orElseThrow();
        return JugadorMapper.INSTANCE.jugadorToJugadorDTO(jugador); // Mapeo de entidad a DTO
    }

    // Crear un nuevo jugador
    public JugadorDTO createJugador(JugadorDTO jugadorDTO) {
        Jugador jugador = JugadorMapper.INSTANCE.jugadorDTOToJugador(jugadorDTO); // Convertir el DTO a entidad
        jugadorRepository.save(jugador);
        return JugadorMapper.INSTANCE.jugadorToJugadorDTO(jugador); // Retornar el DTO actualizado
    }

    // Actualizar un jugador existente
    public JugadorDTO updateJugador(Long id, JugadorDTO jugadorDTO) {
        Jugador jugador = jugadorRepository.findById(id).orElseThrow();
        jugador.setNombre(jugadorDTO.getNombre());
        jugadorRepository.save(jugador);
        return JugadorMapper.INSTANCE.jugadorToJugadorDTO(jugador); // Mapeo de la entidad actualizada a DTO
    }

    // Eliminar un jugador por ID
    public void deleteJugador(Long id) {
        jugadorRepository.deleteById(id);
    }
}
