package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
public class ServicioInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    private Integer cantidad; 

    // Constructores, getters y setters
    public ServicioInventario() {}

    public ServicioInventario(Inventario inventario, Servicio servicio, Integer cantidad) {
        this.inventario = inventario;
        this.servicio = servicio;
        this.cantidad = cantidad;
    }

    // getters y setters

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

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
