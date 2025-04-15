package com.example.demo.Service;

import com.example.demo.dto.JugadorDTO;
import com.example.demo.Mapper.JugadorMapper;
import com.example.demo.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    // Listar todos los jugadores
    public List<JugadorDTO> listarJugadores() {
        return jugadorRepository.findAll().stream()
                .map(JugadorMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener un jugador por su ID
    public Optional<JugadorDTO> obtenerJugadorPorId(Long id) {
        return jugadorRepository.findById(id)
                .map(JugadorMapper::toDTO);
    }

    // Guardar un nuevo jugador
    public void guardarJugador(JugadorDTO jugadorDTO) {
        jugadorRepository.save(JugadorMapper.toEntity(jugadorDTO));
    }

    // Eliminar un jugador por su ID
    public void eliminarJugador(Long id) {
        jugadorRepository.deleteById(id);
    }
}
