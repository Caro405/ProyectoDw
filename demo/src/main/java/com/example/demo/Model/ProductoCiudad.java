package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductoCiudad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer precio;
    private Integer factorDemanda;
    private Integer factorOferta;
    private Integer stock;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Ciudad ciudad;

    // Constructores, getters y setters

    public ProductoCiudad() {}

    public ProductoCiudad(Integer precio, Integer factorDemanda, Integer factorOferta, Integer stock, Producto producto, Ciudad ciudad) {
        this.precio = precio;
        this.factorDemanda = factorDemanda;
        this.factorOferta = factorOferta;
        this.stock = stock;
        this.producto = producto;
        this.ciudad = ciudad;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getFactorDemanda() {
        return factorDemanda;
    }

    public void setFactorDemanda(Integer factorDemanda) {
        this.factorDemanda = factorDemanda;
    }

    public Integer getFactorOferta() {
        return factorOferta;
    }

    public void setFactorOferta(Integer factorOferta) {
        this.factorOferta = factorOferta;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
