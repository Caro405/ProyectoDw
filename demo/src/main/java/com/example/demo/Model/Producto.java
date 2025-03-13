package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Producto {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String categoria;
    private double precioBase;
    private double factorOferta;
    private double factorDemanda;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    // Constructores

    public Producto() {
    }

    public Producto(String nombre, String categoria, double precioBase, double factorOferta, double factorDemanda) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioBase = precioBase;
        this.factorOferta = factorOferta;
        this.factorDemanda = factorDemanda;
    }

    // Setters y Getters

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getFactorOferta() {
        return factorOferta;
    }

    public void setFactorOferta(double factorOferta) {
        this.factorOferta = factorOferta;
    }

    public double getFactorDemanda() {
        return factorDemanda;
    }

    public void setFactorDemanda(double factorDemanda) {
        this.factorDemanda = factorDemanda;
    }
 
    //

    public Ciudad getCiudad() {
        return ciudad;
    } 

}
