package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Servicio {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String nombreservicio;
    private double precio;
    private int porcentajeEfecto;

    @ManyToOne
    private Ciudad ciudad;

    // Constructores

    public Servicio() {}

    public Servicio(Long id, String nombreservicio, double precio, int porcentajeEfecto, Ciudad ciudad) {
        this.id = id;
        this.nombreservicio = nombreservicio;
        this.precio = precio;
        this.porcentajeEfecto = porcentajeEfecto;
        this.ciudad = ciudad;
    }

    // Setters y getters

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPorcentajeEfecto() {
        return porcentajeEfecto;
    }

    public void setPorcentajeEfecto(int porcentajeEfecto) {
        this.porcentajeEfecto = porcentajeEfecto;
    }

    //

    public Ciudad getCiudad() {
        return ciudad;
    }

}
