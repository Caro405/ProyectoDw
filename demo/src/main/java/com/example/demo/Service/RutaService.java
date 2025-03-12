package com.example.demo.Service;

import com.example.demo.dto.RutaDTO;
import com.example.demo.Mapper.RutaMapper;
import com.example.demo.Model.Ciudad;
import com.example.demo.Model.Ruta;
import com.example.demo.Repository.CiudadRepository;
import com.example.demo.Repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    public List<RutaDTO> listarRutas() {
        return rutaRepository.findAll().stream()
                .map(RutaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<RutaDTO> obtenerRutaPorId(Long id) {
        return rutaRepository.findById(id).map(RutaMapper::toDTO);
    }

    public void guardarRuta(RutaDTO rutaDTO) {
        Ciudad ciudadOrigen = ciudadRepository.findById(rutaDTO.getCiudadOrigenId()).orElseThrow();
        Ciudad ciudadDestino = ciudadRepository.findById(rutaDTO.getCiudadDestinoId()).orElseThrow();
        Ruta ruta = RutaMapper.toEntity(rutaDTO, ciudadOrigen, ciudadDestino);
        rutaRepository.save(ruta);
    }

    public void eliminarRuta(Long id) {
        rutaRepository.deleteById(id);
    }
}
