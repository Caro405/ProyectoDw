package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Caravana {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private Integer velocidad;
    private Integer cargaActual;
    private Integer capacidadMaxCarga;
    private Integer dinero;
    private Integer puntosVidaActual;
    private Integer puntosVidaMax;
    private boolean guardias;

    //Relaciones

    @ManyToOne
    private Jugador jugador;

    @OneToOne(mappedBy = "caravana")
    private Inventario inventario; 


    // Constructor sin parámetros
    public Caravana() {}

    // Constructor con todos los parámetros
     public Caravana(String nombre, Integer velocidad, Integer cargaActual, Integer capacidadMaxCarga, Integer dinero,
                    Integer puntosVidaActual, Integer puntosVidaMax, boolean guardias, Jugador jugador, Inventario inventario) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.cargaActual = cargaActual;
        this.capacidadMaxCarga = capacidadMaxCarga;
        this.dinero = dinero;
        this.puntosVidaActual = puntosVidaActual;
        this.puntosVidaMax = puntosVidaMax;
        this.guardias = guardias;
        this.jugador = jugador;
        this.inventario = inventario;  
    }

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

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    
}
