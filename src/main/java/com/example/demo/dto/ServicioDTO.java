package com.example.demo.dto;

public class ServicioDTO {

    private Long id;
    private String nombreservicio;
    private Integer porcentajeEfecto;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreservicio() {
        return nombreservicio;
    }

    public void setNombreservicio(String nombreservicio) {
        this.nombreservicio = nombreservicio;
    }

    public Integer getPorcentajeEfecto() {
        return porcentajeEfecto;
    }

    public void setPorcentajeEfecto(Integer porcentajeEfecto) {
        this.porcentajeEfecto = porcentajeEfecto;
    }

}
