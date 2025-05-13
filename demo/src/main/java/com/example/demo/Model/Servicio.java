package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombreservicio;
    private Integer precio;
    private Integer porcentajeEfecto;

    @ManyToOne 
    private Ciudad ciudad; 
    public Servicio() {}

    public Servicio(String nombreservicio, Integer precio, Integer porcentajeEfecto, Ciudad ciudad) {
        this.nombreservicio = nombreservicio;
        this.precio = precio;
        this.porcentajeEfecto = porcentajeEfecto;
        this.ciudad = ciudad;
    }

    // Getters and Setters
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

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getPorcentajeEfecto() {
        return porcentajeEfecto;
    }

    public void setPorcentajeEfecto(Integer porcentajeEfecto) {
        this.porcentajeEfecto = porcentajeEfecto;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
