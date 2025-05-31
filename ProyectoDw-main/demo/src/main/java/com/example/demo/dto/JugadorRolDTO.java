package com.example.demo.dto;

public class JugadorRolDTO {
    private Long id;
    private Long jugadorId;
    private Long rolId;

    // Constructores
    public JugadorRolDTO() {}

    public JugadorRolDTO(Long id, Long jugadorId, Long rolId) {
        this.id = id;
        this.jugadorId = jugadorId;
        this.rolId = rolId;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getJugadorId() { return jugadorId; }
    public void setJugadorId(Long jugadorId) { this.jugadorId = jugadorId; }
    public Long getRolId() { return rolId; }
    public void setRolId(Long rolId) { this.rolId = rolId; }
}