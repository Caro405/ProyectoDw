package com.example.demo.dto;

public class JugadoresSesionDTO {

    private Long id;
    private Long jugadorId;
    private Long sesionJuegoId;

    public JugadoresSesionDTO() {}

    public JugadoresSesionDTO(Long id, Long jugadorId, Long sesionJuegoId) {
        this.id = id;
        this.jugadorId = jugadorId;
        this.sesionJuegoId = sesionJuegoId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJugadorId() {
        return jugadorId;
    }

    public void setJugadorId(Long jugadorId) {
        this.jugadorId = jugadorId;
    }

    public Long getSesionJuegoId() {
        return sesionJuegoId;
    }

    public void setSesionJuegoId(Long sesionJuegoId) {
        this.sesionJuegoId = sesionJuegoId;
    }
}
