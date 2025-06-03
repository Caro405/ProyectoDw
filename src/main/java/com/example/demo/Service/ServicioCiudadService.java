package com.example.demo.Service;

import com.example.demo.Model.ServicioCiudad;
import com.example.demo.Repository.ServicioCiudadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCiudadService {

    private final ServicioCiudadRepository repository;

    public ServicioCiudadService(ServicioCiudadRepository repository) {
        this.repository = repository;
    }

    public List<ServicioCiudad> findAll() {
        return repository.findAll();
    }

    public Optional<ServicioCiudad> findById(Long id) {
        return repository.findById(id);
    }

    public ServicioCiudad save(ServicioCiudad sc) {
        return repository.save(sc);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

