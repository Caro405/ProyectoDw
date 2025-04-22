package com.example.demo.dto;

import com.example.demo.Model.Producto;
import com.example.demo.Model.Ciudad;

public class ProductoCiudadDTO {

    private Long id;
    private Integer precio;
    private Integer factorDemanda;
    private Integer factorOferta;
    private Integer stock;
    private Producto producto;
    private Ciudad ciudad;

    // Constructores, getters y setters
    public ProductoCiudadDTO() {}

    public ProductoCiudadDTO(Integer precio, Integer factorDemanda, Integer factorOferta, Integer stock, Producto producto, Ciudad ciudad) {
        this.precio = precio;
        this.factorDemanda = factorDemanda;
        this.factorOferta = factorOferta;
        this.stock = stock;
        this.producto = producto;
        this.ciudad = ciudad;
    }

    // Getters y setters
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
