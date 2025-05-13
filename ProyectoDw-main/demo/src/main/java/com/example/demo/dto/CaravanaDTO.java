package com.example.demo.dto;

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

    private InventarioDTO inventarioDTO;  // Agregar propiedad inventarioDTO

    public CaravanaDTO() {}

    public CaravanaDTO(Long id, String nombre, Integer velocidad, Integer cargaActual, Integer capacidadMaxCarga, Integer dinero, Integer puntosVidaActual, Integer puntosVidaMax, boolean guardias, InventarioDTO inventarioDTO) {
        this.id = id;
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.cargaActual = cargaActual;
        this.capacidadMaxCarga = capacidadMaxCarga;
        this.dinero = dinero;
        this.puntosVidaActual = puntosVidaActual;
        this.puntosVidaMax = puntosVidaMax;
        this.guardias = guardias;
        this.inventarioDTO = inventarioDTO;  // Asignar inventarioDTO en el constructor
    }

    // Getters y Setters
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

    // Agregar los métodos getter y setter para inventarioDTO
    public InventarioDTO getInventarioDTO() {
        return inventarioDTO;
    }

    public void setInventarioDTO(InventarioDTO inventarioDTO) {
        this.inventarioDTO = inventarioDTO;
    }
}
