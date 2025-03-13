package com.example.demo.Model;

import jakarta.persistence.*;
//import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private double precioBase;
    private double factorOferta;
    private double factorDemanda;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    // Lista de categorías permitidas
    public enum Categoria {
        ESPECIA,
        TELA,
        ARMA,
        METAL_PRECIOSO,
        GANADO
    }

    // Constructores
    public Producto() {}

    public Producto(String nombre, Categoria categoria, double precioBase, double factorOferta, double factorDemanda, Ciudad ciudad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioBase = precioBase;
        this.factorOferta = factorOferta;
        this.factorDemanda = factorDemanda;
        this.ciudad = ciudad;
    }

    // Setters y Getters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public double getFactorOferta() { return factorOferta; }
    public void setFactorOferta(double factorOferta) { this.factorOferta = factorOferta; }

    public double getFactorDemanda() { return factorDemanda; }
    public void setFactorDemanda(double factorDemanda) { this.factorDemanda = factorDemanda; }

    public Ciudad getCiudad() { return ciudad; }
    public void setCiudad(Ciudad ciudad) { this.ciudad = ciudad; }
}
