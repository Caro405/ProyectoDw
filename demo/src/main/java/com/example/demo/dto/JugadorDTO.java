package com.example.demo.dto;

import com.example.demo.dto.JugadorDTO;

public class JugadorDTO {

    private Long id;
    private String nombre;
    private Long sesionJuegoId; 

    public JugadorDTO() {}

    public JugadorDTO(Long id, String nombre, Long sesionJuegoId) {
        this.id = id;
        this.nombre = nombre;
        this.sesionJuegoId = sesionJuegoId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getSesionJuegoId() {
        return sesionJuegoId;
    }

    public void setSesionJuegoId(Long sesionJuegoId) {
        this.sesionJuegoId = sesionJuegoId;
    }
}
