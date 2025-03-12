package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double distancia;
    private boolean esSegura;
    private double ataque;
    private String causaAtaque;

    // Relaciones
    @ManyToOne
    private Ciudad ciudadOrigen;

    @ManyToOne
    private Ciudad ciudadDestino;

    public Ruta() {}

    public Ruta(double distancia, boolean esSegura, double ataque, String causaAtaque) {
        this.distancia = distancia;
        this.esSegura = esSegura;
        this.ataque = ataque;
        this.causaAtaque = causaAtaque;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getDistancia() { return distancia; }
    public void setDistancia(double distancia) { this.distancia = distancia; }

    public boolean isEsSegura() { return esSegura; }
    public void setEsSegura(boolean esSegura) { this.esSegura = esSegura; }

    public double getAtaque() { return ataque; }
    public void setAtaque(double ataque) { this.ataque = ataque; }

    public String getCausaAtaque() { return causaAtaque; }
    public void setCausaAtaque(String causaAtaque) { this.causaAtaque = causaAtaque; }

    public Ciudad getCiudadOrigen() { return ciudadOrigen; }
    public void setCiudadOrigen(Ciudad ciudadOrigen) { this.ciudadOrigen = ciudadOrigen; }

    public Ciudad getCiudadDestino() { return ciudadDestino; }
    public void setCiudadDestino(Ciudad ciudadDestino) { this.ciudadDestino = ciudadDestino; }
}
