package com.example.demo.dto;

public class RutaDTO {

    private Long id;
    private Integer distancia;
    private boolean esSegura;
    private Integer ataque;
    private String causaAtaque;
    private Long ciudadOrigenId;
    private Long ciudadDestinoId;
    private String ciudadOrigenNombre;
    private String ciudadDestinoNombre;

    public RutaDTO() {}

    public RutaDTO(Long id, Integer distancia, boolean esSegura, Integer ataque, String causaAtaque, 
                   Long ciudadOrigenId, Long ciudadDestinoId, String ciudadOrigenNombre, String ciudadDestinoNombre) {
        this.id = id;
        this.distancia = distancia;
        this.esSegura = esSegura;
        this.ataque = esSegura ? 0 : ataque;  // Si la ruta es segura, no hay ataque
        this.causaAtaque = esSegura ? null : causaAtaque;  // Si es segura, no hay causa de ataque
        this.ciudadOrigenId = ciudadOrigenId;
        this.ciudadDestinoId = ciudadDestinoId;
        this.ciudadOrigenNombre = ciudadOrigenNombre;
        this.ciudadDestinoNombre = ciudadDestinoNombre;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getDistancia() { return distancia; }
    public void setDistancia(Integer distancia) { this.distancia = distancia; }

    public boolean isEsSegura() { return esSegura; }
    public void setEsSegura(boolean esSegura) { 
        this.esSegura = esSegura; 
        if (esSegura) { 
            this.ataque = 0; 
            this.causaAtaque = null; 
        }
    }

    public Integer getAtaque() { return ataque; }
    public void setAtaque(Integer ataque) { this.ataque = esSegura ? 0 : ataque; }

    public String getCausaAtaque() { return causaAtaque; }
    public void setCausaAtaque(String causaAtaque) { this.causaAtaque = esSegura ? null : causaAtaque; }

    public Long getCiudadOrigenId() { return ciudadOrigenId; }
    public void setCiudadOrigenId(Long ciudadOrigenId) { this.ciudadOrigenId = ciudadOrigenId; }

    public Long getCiudadDestinoId() { return ciudadDestinoId; }
    public void setCiudadDestinoId(Long ciudadDestinoId) { this.ciudadDestinoId = ciudadDestinoId; }

    public String getCiudadOrigenNombre() { return ciudadOrigenNombre; }
    public void setCiudadOrigenNombre(String ciudadOrigenNombre) { this.ciudadOrigenNombre = ciudadOrigenNombre; }

    public String getCiudadDestinoNombre() { return ciudadDestinoNombre; }
    public void setCiudadDestinoNombre(String ciudadDestinoNombre) { this.ciudadDestinoNombre = ciudadDestinoNombre; }
}
