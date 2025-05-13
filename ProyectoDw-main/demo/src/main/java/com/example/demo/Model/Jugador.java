package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "jugador")
    private List<Caravana> caravanas;

    @OneToMany(mappedBy = "jugador")
    private List<JugadorRol> roles;

    public Jugador() {}

    public Jugador(String nombre) {
        this.nombre = nombre;
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

    public List<Caravana> getCaravanas() {
        return caravanas;
    }

    public void setCaravanas(List<Caravana> caravanas) {
        this.caravanas = caravanas;
    }

    public List<JugadorRol> getRoles() {
        return roles;
    }

    public void setRoles(List<JugadorRol> roles) {
        this.roles = roles;
    }
}
