package com.example.demo.Controller;

import com.example.demo.Mapper.ServicioCiudadMapper;
import com.example.demo.Model.Ciudad;
import com.example.demo.Model.Servicio;
import com.example.demo.Model.ServicioCiudad;
import com.example.demo.Repository.CiudadRepository;
import com.example.demo.Repository.ServicioRepository;
import com.example.demo.Service.ServicioCiudadService;
import com.example.demo.dto.ServicioCiudadDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/servicio-ciudad")
public class ServicioCiudadController {

    private final ServicioCiudadService service;
    private final CiudadRepository ciudadRepo;
    private final ServicioRepository servicioRepo;

    public ServicioCiudadController(ServicioCiudadService service, CiudadRepository ciudadRepo, ServicioRepository servicioRepo) {
        this.service = service;
        this.ciudadRepo = ciudadRepo;
        this.servicioRepo = servicioRepo;
    }

    @GetMapping
    public List<ServicioCiudadDTO> findAll() {
        return service.findAll().stream()
                .map(ServicioCiudadMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ServicioCiudadDTO> create(@RequestBody ServicioCiudadDTO dto) {
        ServicioCiudad entity = ServicioCiudadMapper.INSTANCE.toEntity(dto);

        Ciudad ciudad = ciudadRepo.findById(dto.getCiudadId()).orElseThrow();
        Servicio servicio = servicioRepo.findById(dto.getServicioId()).orElseThrow();

        entity.setCiudad(ciudad);
        entity.setServicio(servicio);

        return ResponseEntity.ok(
                ServicioCiudadMapper.INSTANCE.toDTO(service.save(entity))
        );
    }

    @GetMapping("/ciudad/{id}")
    public List<ServicioCiudadDTO> findByCiudad(@PathVariable Long id) {
        return service.findAll().stream()
                .filter(sc -> sc.getCiudad().getId().equals(id))
                .map(ServicioCiudadMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
