package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ruta {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private double distancia; 
    private boolean esSegura;
    private double ataque; 
    private String causaAtaque;

    // Relaciones con las otras clases

    @ManyToOne
    private Ciudad ciudadOrigen;

    @ManyToOne
    private Ciudad ciudadDestino;

    //Constructores
    public Ruta() {
    }
    
    public Ruta(double distancia, boolean esSegura, double ataque, String causaAtaque) {
        this.distancia = distancia;
        this.esSegura = esSegura;
        this.ataque = ataque;
        this.causaAtaque = causaAtaque;
    }

    //Setters y getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public boolean isEsSegura() {
        return esSegura;
    }

    public void setEsSegura(boolean esSegura) {
        this.esSegura = esSegura;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public String getCausaAtaque() {
        return causaAtaque;
    }

    public void setCausaAtaque(String causaAtaque) {
        this.causaAtaque = causaAtaque;
    }

    //

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

}
