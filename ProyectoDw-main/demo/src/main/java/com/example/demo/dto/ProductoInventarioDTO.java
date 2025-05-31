package com.example.demo.dto;

import java.util.Objects;

public class ProductoInventarioDTO {
    private Long id;
    private Long inventarioId;
    private Long productoId;
    private Integer cantidad;

    // Constructores
    public ProductoInventarioDTO() {}

    public ProductoInventarioDTO(Long id, Long inventarioId, Long productoId, Integer cantidad) {
        this.id = id;
        this.inventarioId = inventarioId;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(Long inventarioId) {
        this.inventarioId = inventarioId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoInventarioDTO that = (ProductoInventarioDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return "ProductoInventarioDTO{" +
                "id=" + id +
                ", inventarioId=" + inventarioId +
                ", productoId=" + productoId +
                ", cantidad=" + cantidad +
                '}';
    }
}