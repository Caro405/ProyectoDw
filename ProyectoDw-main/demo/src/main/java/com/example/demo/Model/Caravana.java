package com.example.demo.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Caravana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer velocidad;
    private Integer cargaActual;
    private Integer capacidadMaxCarga;
    private Integer dinero;
    private Integer puntosVidaActual;
    private Integer puntosVidaMax;
    private boolean guardias;

    // Relación OneToMany con Jugador
    @OneToMany(mappedBy = "caravana", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Jugador> jugadores = new ArrayList<>();

    // Relación OneToOne con Inventario 
    @OneToOne(mappedBy = "caravana", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Inventario inventario;

    // Constructores
    public Caravana() {}

    public Caravana(String nombre, Integer velocidad, Integer cargaActual, Integer capacidadMaxCarga, 
                   Integer dinero, Integer puntosVidaActual, Integer puntosVidaMax, 
                   boolean guardias) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.cargaActual = cargaActual;
        this.capacidadMaxCarga = capacidadMaxCarga;
        this.dinero = dinero;
        this.puntosVidaActual = puntosVidaActual;
        this.puntosVidaMax = puntosVidaMax;
        this.guardias = guardias;
    }

    // Métodos para manejo de relaciones bidireccionales
    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
        jugador.setCaravana(this);
    }

    public void removeJugador(Jugador jugador) {
        jugadores.remove(jugador);
        jugador.setCaravana(null);
    }

    public void setInventario(Inventario inventario) {
        if (inventario == null) {
            if (this.inventario != null) {
                this.inventario.setCaravana(null);
            }
        } else {
            inventario.setCaravana(this);
        }
        this.inventario = inventario;
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

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Inventario getInventario() {
        return inventario;
    }
}