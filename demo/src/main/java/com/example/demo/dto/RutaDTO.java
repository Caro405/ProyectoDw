package com.example.demo.dto;

public class RutaDTO {
    private Long id;
    private int distancia; 
    private boolean esSegura;
    private int ataque; 
    private String causaAtaque;
    private Long ciudadOrigenId;
    private Long ciudadDestinoId;

    public RutaDTO() {}

    public RutaDTO(Long id, int distancia, boolean esSegura, int ataque, String causaAtaque, Long ciudadOrigenId, Long ciudadDestinoId) {
        this.id = id;
        this.distancia = distancia;
        this.esSegura = esSegura;
        this.ataque = esSegura ? 0 : ataque; // 🔹 Si es segura, ataque = 0
        this.causaAtaque = esSegura ? null : causaAtaque; // 🔹 Si es segura, causaAtaque = null
        this.ciudadOrigenId = ciudadOrigenId;
        this.ciudadDestinoId = ciudadDestinoId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getDistancia() { return distancia; }
    public void setDistancia(int distancia) { this.distancia = distancia; }

    public boolean isEsSegura() { return esSegura; }
    public void setEsSegura(boolean esSegura) { 
        this.esSegura = esSegura; 
        if (esSegura) { 
            this.ataque = 0; 
            this.causaAtaque = null; 
        }
    }

    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { 
        this.ataque = esSegura ? 0 : ataque; 
    }

    public String getCausaAtaque() { return causaAtaque; }
    public void setCausaAtaque(String causaAtaque) { 
        this.causaAtaque = esSegura ? null : causaAtaque; 
    }

    public Long getCiudadOrigenId() { return ciudadOrigenId; }
    public void setCiudadOrigenId(Long ciudadOrigenId) { this.ciudadOrigenId = ciudadOrigenId; }

    public Long getCiudadDestinoId() { return ciudadDestinoId; }
    public void setCiudadDestinoId(Long ciudadDestinoId) { this.ciudadDestinoId = ciudadDestinoId; }
}
