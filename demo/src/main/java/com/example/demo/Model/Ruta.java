package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int distancia;
    private boolean esSegura;
    private int ataque;
    private String causaAtaque;

    // Relaciones
    @ManyToOne
    private Ciudad ciudadOrigen;

    @ManyToOne
    private Ciudad ciudadDestino;

    public Ruta() {}

    public Ruta(int distancia, boolean esSegura, int ataque, String causaAtaque) {
        this.distancia = distancia;
        this.esSegura = esSegura;
        this.ataque = ataque;
        this.causaAtaque = esSegura ? null : causaAtaque; 
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getDistancia() { return distancia; }
    public void setDistancia(int distancia) { this.distancia = distancia; }

    public boolean isEsSegura() { return esSegura; }
    public void setEsSegura(boolean esSegura) { 
        this.esSegura = esSegura;
        if (esSegura) this.causaAtaque = null; 
    }

    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }

    public String getCausaAtaque() { return causaAtaque; }
    public void setCausaAtaque(String causaAtaque) { 
        this.causaAtaque = esSegura ? null : causaAtaque; 
    }

    public Ciudad getCiudadOrigen() { return ciudadOrigen; }
    public void setCiudadOrigen(Ciudad ciudadOrigen) { this.ciudadOrigen = ciudadOrigen; }

    public Ciudad getCiudadDestino() { return ciudadDestino; }
    public void setCiudadDestino(Ciudad ciudadDestino) { this.ciudadDestino = ciudadDestino; }
}
