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
    private String efecto;

    @ManyToOne
    private Ciudad ciudad;

    // Constructores

    public Servicio() {
    }

    public Servicio(String nombreservicio, double precio, String efecto) {
        this.nombreservicio = nombreservicio;
        this.precio = precio;
        this.efecto = efecto;
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

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    //

    public Ciudad getCiudad() {
        return ciudad;
    }

}
