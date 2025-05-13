package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rol;

    @OneToMany(mappedBy = "rol")
    private List<JugadorRol> jugadores;

    public Rol() {}

    public Rol(String rol) {
        this.rol = rol;
    }

    // Getters y Setters
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

    public List<JugadorRol> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorRol> jugadores) {
        this.jugadores = jugadores;
    }
}
