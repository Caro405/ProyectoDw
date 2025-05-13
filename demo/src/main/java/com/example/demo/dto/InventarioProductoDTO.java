package com.example.demo.dto;

public class InventarioProductoDTO {

    private Long id;
    private Long productoId;  // Solo el ID del producto
    private Long inventarioId;  // Solo el ID del inventario
    private Integer cantidad;

    public InventarioProductoDTO() {}

    public InventarioProductoDTO(Long id, Long productoId, Long inventarioId, Integer cantidad) {
        this.id = id;
        this.productoId = productoId;
        this.inventarioId = inventarioId;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(Long inventarioId) {
        this.inventarioId = inventarioId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
