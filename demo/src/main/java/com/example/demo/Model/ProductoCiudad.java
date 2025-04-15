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

    Integer precio;
    Integer factor_demanda;
    Integer factor_oferta;
    Integer stock;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Ciudad ciudad;

    public ProductoCiudad() {
    }

    public ProductoCiudad(Integer factor_demanda, Integer factor_oferta, Integer stock, Producto producto, Ciudad ciudad) {
        this.factor_demanda = factor_demanda;
        this.factor_oferta = factor_oferta;
        this.stock = stock;
        this.producto = producto;
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFactor_demanda() {
        return factor_demanda;
    }

    public void setFactor_demanda(Integer factor_demanda) {
        this.factor_demanda = factor_demanda;
    }

    public Integer getFactor_oferta() {
        return factor_oferta;
    }

    public void setFactor_oferta(Integer factor_oferta) {
        this.factor_oferta = factor_oferta;
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
