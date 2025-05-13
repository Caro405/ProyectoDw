package com.example.demo.Service;

import com.example.demo.dto.CaravanaDTO;
import com.example.demo.Model.Caravana;
import com.example.demo.Model.Inventario;
import com.example.demo.Mapper.CaravanaMapper;
import com.example.demo.Mapper.InventarioMapper;

import com.example.demo.Repository.CaravanaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaravanaService {

 @Autowired
private InventarioService inventarioService;

public CaravanaDTO createCaravana(CaravanaDTO caravanaDTO) {
    Caravana caravana = caravanaMapper.toEntity(caravanaDTO);

    // Crear el inventario relacionado
    Inventario inventario = inventarioMapper.toEntity(caravanaDTO.getInventarioDTO());
    caravana.setInventario(inventario);

    // Guardar la caravana
    caravana = caravanaRepository.save(caravana);

    return caravanaMapper.toDTO(caravana);
}

}
