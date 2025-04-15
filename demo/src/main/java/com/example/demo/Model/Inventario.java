package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //falta cantidad???
    

    @ManyToOne
    private Caravana caravana;

    @ManyToOne
    private Producto producto;


    public Inventario() {
    }

    public Inventario(Caravana caravana, Producto producto) {
        this.caravana = caravana;
        this.producto = producto;
    }

    public Caravana getCaravana() {
        return caravana;
    }

    public void setCaravana(Caravana caravana) {
        this.caravana = caravana;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
