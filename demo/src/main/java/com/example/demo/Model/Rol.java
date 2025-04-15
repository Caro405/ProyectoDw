package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rol;

    @ManyToOne
    private JugadoresSesion jugadoresSesion;

    public Rol() {}

    public Rol(String rol) {
        this.rol = rol;
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

    public JugadoresSesion getJugadoresSesion() {
        return jugadoresSesion;
    }

    public void setJugadoresSesion(JugadoresSesion jugadoresSesion) {
        this.jugadoresSesion = jugadoresSesion;
    }
}
