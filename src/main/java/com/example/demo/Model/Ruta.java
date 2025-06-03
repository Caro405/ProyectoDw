package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer distancia;
    private boolean esSegura;
    private Integer ataque;
    private String causaAtaque;

    @ManyToOne
    private Ciudad ciudadOrigen;

    @ManyToOne
    private Ciudad ciudadDestino;

    public Ruta() {}

    public Ruta(Integer distancia, boolean esSegura, Integer ataque, String causaAtaque) {
        this.distancia = distancia;
        this.esSegura = esSegura;
        this.ataque = ataque;
        this.causaAtaque = causaAtaque;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public boolean isEsSegura() {
        return esSegura;
    }

    public void setEsSegura(boolean esSegura) {
        this.esSegura = esSegura;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public String getCausaAtaque() {
        return causaAtaque;
    }

    public void setCausaAtaque(String causaAtaque) {
        this.causaAtaque = causaAtaque;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
}
 