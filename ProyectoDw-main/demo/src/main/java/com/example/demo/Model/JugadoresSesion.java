package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class JugadoresSesion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Jugador jugador;

    @ManyToOne
    private SesionJuego sesionJuego;

    public JugadoresSesion() {}

    public JugadoresSesion(Jugador jugador, SesionJuego sesionJuego) {
        this.jugador = jugador;
        this.sesionJuego = sesionJuego;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public SesionJuego getSesionJuego() {
        return sesionJuego;
    }

    public void setSesionJuego(SesionJuego sesionJuego) {
        this.sesionJuego = sesionJuego;
    }
}
