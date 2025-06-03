package com.example.demo.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "caravana_id")
private Caravana caravana;


    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JugadorRol> roles = new ArrayList<>();

    // Constructores
    public Jugador() {}

    public Jugador(String nombre, Caravana caravana) {
        this.nombre = nombre;
        this.caravana = caravana;
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

    public Caravana getCaravana() {
        return caravana;
    }

    public void setCaravana(Caravana caravana) {
        this.caravana = caravana;
    }

    public List<JugadorRol> getRoles() {
        return roles;
    }

    public void setRoles(List<JugadorRol> roles) {
        this.roles = roles;
    }

    // Métodos utilitarios para manejar la relación bidireccional
    public void addRol(JugadorRol jugadorRol) {
        roles.add(jugadorRol);
        jugadorRol.setJugador(this);
    }

    public void removeRol(JugadorRol jugadorRol) {
        roles.remove(jugadorRol);
        jugadorRol.setJugador(null);
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return id != null && id.equals(jugador.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // toString
    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", caravanaId=" + (caravana != null ? caravana.getId() : null) +
                '}';
    }
}