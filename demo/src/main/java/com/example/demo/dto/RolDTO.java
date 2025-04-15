package com.example.demo.dto;

public class RolDTO {

    private Long id;
    private String rol;
    private Long jugadoresSesionId;

    public RolDTO() {}

    public RolDTO(Long id, String rol, Long jugadoresSesionId) {
        this.id = id;
        this.rol = rol;
        this.jugadoresSesionId = jugadoresSesionId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Long getJugadoresSesionId() {
        return jugadoresSesionId;
    }

    public void setJugadoresSesionId(Long jugadoresSesionId) {
        this.jugadoresSesionId = jugadoresSesionId;
    }
}
