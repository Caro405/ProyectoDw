package com.example.demo.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CiudadDTO {
    private Long id;
    private String nombre;
    private BigDecimal impuestos;

    public CiudadDTO() {}

    public CiudadDTO(Long id, String nombre, BigDecimal impuestos) {
        this.id = id;
        this.nombre = nombre;
        this.impuestos = impuestos.setScale(2, RoundingMode.HALF_UP); // ✅ moderno
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(BigDecimal impuestos) {
        this.impuestos = impuestos.setScale(2, RoundingMode.HALF_UP); // ✅ moderno
    }
}
