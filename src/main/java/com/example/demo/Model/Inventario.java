package com.example.demo.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación OneToOne con Caravana (lado propietario)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caravana_id", unique = true)
    private Caravana caravana;

    // Relación OneToMany con ProductoInventario
    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoInventario> productosInventario = new ArrayList<>();

    // Relación OneToMany con ServicioInventario
    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServicioInventario> serviciosInventario = new ArrayList<>();

    // Constructores
    public Inventario() {}

    public Inventario(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para manejo de relaciones bidireccionales
    public void addProductoInventario(ProductoInventario productoInventario) {
        productosInventario.add(productoInventario);
        productoInventario.setInventario(this);
    }

    public void removeProductoInventario(ProductoInventario productoInventario) {
        productosInventario.remove(productoInventario);
        productoInventario.setInventario(null);
    }

    public void addServicioInventario(ServicioInventario servicioInventario) {
        serviciosInventario.add(servicioInventario);
        servicioInventario.setInventario(this);
    }

    public void removeServicioInventario(ServicioInventario servicioInventario) {
        serviciosInventario.remove(servicioInventario);
        servicioInventario.setInventario(null);
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Caravana getCaravana() {
        return caravana;
    }

    public void setCaravana(Caravana caravana) {
        this.caravana = caravana;
        // Asegurar la sincronización bidireccional
        if (caravana != null && caravana.getInventario() != this) {
            caravana.setInventario(this);
        }
    }

    public List<ProductoInventario> getProductosInventario() {
        return productosInventario;
    }

    public void setProductosInventario(List<ProductoInventario> productosInventario) {
        this.productosInventario = productosInventario;
    }

    public List<ServicioInventario> getServiciosInventario() {
        return serviciosInventario;
    }

    public void setServiciosInventario(List<ServicioInventario> serviciosInventario) {
        this.serviciosInventario = serviciosInventario;
    }
}