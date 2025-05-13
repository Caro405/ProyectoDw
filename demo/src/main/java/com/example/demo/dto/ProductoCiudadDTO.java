package com.example.demo.dto;

public class ProductoCiudadDTO {

    private Long id;
    private Integer precio;
    private Integer factorDemanda;
    private Integer factorOferta;
    private Integer stock;
    private Long productoId;  // Relación con Producto (solo el ID)
    private Long ciudadId;    // Relación con Ciudad (solo el ID)

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

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Long ciudadId) {
        this.ciudadId = ciudadId;
    }
}
