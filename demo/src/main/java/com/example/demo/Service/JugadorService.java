package com.example.demo.Service;

import com.example.demo.Repository.JugadorRepository;
import com.example.demo.Model.Jugador;
import com.example.demo.dto.JugadorDTO;
import com.example.demo.mapper.JugadorMapper;  // Asegúrate de tener el mapeo correcto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;  // Importar la clase Page correctamente
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
                .map(JugadorMapper::toDTO)  // Usar el mapeo adecuado
                .collect(Collectors.toList());
    }

    // Listar jugadores con paginación
    public Page<JugadorDTO> listaJugador(PageRequest pageRequest) {
        return jugadorRepository.findAll(pageRequest).map(JugadorMapper::toDTO);  // Asegúrate de que retorna un Page<JugadorDTO>
    }

    // Buscar jugadores por nombre
    public List<JugadorDTO> buscarJugadoresPorNombre(String nombre) {
        return jugadorRepository.findAllByNombre(nombre).stream()
                .map(JugadorMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar jugador por ID
    public Optional<JugadorDTO> buscarJugador(Long id) {
        return jugadorRepository.findById(id).map(JugadorMapper::toDTO);  // Usar el mapeo adecuado
    }

    // Crear un nuevo jugador
    public JugadorDTO crearJugador(JugadorDTO jugadorDTO) {
        Jugador jugador = JugadorMapper.toEntity(jugadorDTO);  // Convertir de DTO a la entidad
        return JugadorMapper.toDTO(jugadorRepository.save(jugador));  // Guardar y convertir de vuelta a DTO
    }

    // Actualizar un jugador existente
    public JugadorDTO actualizarJugador(JugadorDTO jugadorDTO) {
        Jugador jugador = JugadorMapper.toEntity(jugadorDTO);  // Convertir DTO a entidad
        return JugadorMapper.toDTO(jugadorRepository.save(jugador));  // Guardar y retornar el DTO actualizado
    }

    // Eliminar un jugador
    public void borrarJugador(Long id) {
        jugadorRepository.deleteById(id);  // Eliminar jugador por ID
    }
}
