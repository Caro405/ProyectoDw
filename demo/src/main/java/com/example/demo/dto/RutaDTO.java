package com.example.demo.dto;

public class RutaDTO {
    private Long id;
    private double distancia;
    private boolean esSegura;
    private double ataque;
    private String causaAtaque;
    private Long ciudadOrigenId;
    private Long ciudadDestinoId;

    public RutaDTO() {}

    public RutaDTO(Long id, double distancia, boolean esSegura, double ataque, String causaAtaque, Long ciudadOrigenId, Long ciudadDestinoId) {
        this.id = id;
        this.distancia = distancia;
        this.esSegura = esSegura;
        this.ataque = ataque;
        this.causaAtaque = causaAtaque;
        this.ciudadOrigenId = ciudadOrigenId;
        this.ciudadDestinoId = ciudadDestinoId;
    }

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

    public Long getCiudadOrigenId() { return ciudadOrigenId; }
    public void setCiudadOrigenId(Long ciudadOrigenId) { this.ciudadOrigenId = ciudadOrigenId; }

    public Long getCiudadDestinoId() { return ciudadDestinoId; }
    public void setCiudadDestinoId(Long ciudadDestinoId) { this.ciudadDestinoId = ciudadDestinoId; }
}
