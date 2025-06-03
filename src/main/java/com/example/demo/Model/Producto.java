package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Integer precioBase;
    private Integer factorOferta;
    private Integer factorDemanda;

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

    public Producto(String nombre, Categoria categoria, Integer precioBase, Integer factorOferta, Integer factorDemanda) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioBase = precioBase;
        this.factorOferta = factorOferta;
        this.factorDemanda = factorDemanda;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public Integer getPrecioBase() { return precioBase; }
    public void setPrecioBase(Integer precioBase) { this.precioBase = precioBase; }

    public Integer getFactorOferta() { return factorOferta; }
    public void setFactorOferta(Integer factorOferta) { this.factorOferta = factorOferta; }

    public Integer getFactorDemanda() {
        return factorDemanda;
    }

    public void setFactorDemanda(Integer factorDemanda) {
        this.factorDemanda = factorDemanda;
    }


}
