package com.example.demo.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class JugadoresSesion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    Date ultima_actividad;

    @OneToMany (mappedBy = "jugadoresSesion")
    private List<Jugador> jugadores = new ArrayList<>();

    @OneToMany (mappedBy = "jugadoresSesion")
    private List<Jugador> rol = new ArrayList<>();

}
