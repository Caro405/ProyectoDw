package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a IDENTITY para mejor soporte en diferentes DBs
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inventario_id", referencedColumnName = "id") // Más explícito
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id") // Más explícito
    private Producto producto;

    private Integer cantidad;

    // Constructores
    public ProductoInventario() {}

    public ProductoInventario(Inventario inventario, Producto producto, Integer cantidad) {
        this.inventario = inventario;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Getters y setters 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getInventarioId() {
        return inventario != null ? inventario.getId() : null;
    }
}