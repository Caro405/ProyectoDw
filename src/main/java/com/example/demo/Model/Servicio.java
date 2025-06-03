package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombreservicio;
    private Integer porcentajeEfecto;

    public Servicio() {}

    public Servicio(String nombreservicio, Integer porcentajeEfecto) {
        this.nombreservicio = nombreservicio;
        this.porcentajeEfecto = porcentajeEfecto;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreservicio() { return nombreservicio; }
    public void setNombreservicio(String nombreservicio) { this.nombreservicio = nombreservicio; }

    public Integer getPorcentajeEfecto() { return porcentajeEfecto; }
    public void setPorcentajeEfecto(Integer porcentajeEfecto) { this.porcentajeEfecto = porcentajeEfecto; }
}
