package com.example.demo.dto;

import java.util.List;

public class CaravanaDTO {

    private Long id;
    private String nombre;
    private Integer velocidad;
    private Integer cargaActual;
    private Integer capacidadMaxCarga;
    private Integer dinero;
    private Integer puntosVidaActual;
    private Integer puntosVidaMax;
    private boolean guardias;

    // Solo incluimos los IDs de jugadores para evitar ciclos o datos innecesarios
    private List<Long> jugadoresIds;

    private Long inventarioId;

    public CaravanaDTO() {}

    // Getters y setters

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

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getCargaActual() {
        return cargaActual;
    }

    public void setCargaActual(Integer cargaActual) {
        this.cargaActual = cargaActual;
    }

    public Integer getCapacidadMaxCarga() {
        return capacidadMaxCarga;
    }

    public void setCapacidadMaxCarga(Integer capacidadMaxCarga) {
        this.capacidadMaxCarga = capacidadMaxCarga;
    }

    public Integer getDinero() {
        return dinero;
    }

    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

    public Integer getPuntosVidaActual() {
        return puntosVidaActual;
    }

    public void setPuntosVidaActual(Integer puntosVidaActual) {
        this.puntosVidaActual = puntosVidaActual;
    }

    public Integer getPuntosVidaMax() {
        return puntosVidaMax;
    }

    public void setPuntosVidaMax(Integer puntosVidaMax) {
        this.puntosVidaMax = puntosVidaMax;
    }

    public boolean isGuardias() {
        return guardias;
    }

    public void setGuardias(boolean guardias) {
        this.guardias = guardias;
    }

    public List<Long> getJugadoresIds() {
        return jugadoresIds;
    }

    public void setJugadoresIds(List<Long> jugadoresIds) {
        this.jugadoresIds = jugadoresIds;
    }

    public Long getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(Long inventarioId) {
        this.inventarioId = inventarioId;
    }
}
