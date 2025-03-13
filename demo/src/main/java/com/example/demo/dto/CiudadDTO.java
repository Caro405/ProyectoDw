package com.example.demo.dto;

import java.math.BigDecimal;

public class CiudadDTO {
    private Long id;
    private String nombre;
    private BigDecimal impuestos;

    public CiudadDTO() {}

    @SuppressWarnings("deprecation")
    public CiudadDTO(Long id, String nombre, BigDecimal impuestos) {
        this.id = id;
        this.nombre = nombre;
        this.impuestos = impuestos.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getImpuestos() { return impuestos; }
    @SuppressWarnings("deprecation")
    public void setImpuestos(BigDecimal impuestos) { 
        this.impuestos = impuestos.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
