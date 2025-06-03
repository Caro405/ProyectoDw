package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JugadorSesion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "sesion_juego_id")
    private SesionJuego sesionJuego;


    public JugadorSesion() {}

    public JugadorSesion(Jugador jugador, SesionJuego sesionJuego) {
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
