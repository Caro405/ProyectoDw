package com.example.demo.Model;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;
=======
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
>>>>>>> main

@Entity
public class Ciudad {

    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @Column(precision = 10, scale = 2) // Dos decimales
    private BigDecimal impuestos;

    // Relaciones
    @OneToMany(mappedBy = "ciudadOrigen", cascade = CascadeType.ALL)
    private List<Ruta> rutasSalida;

    @OneToMany(mappedBy = "ciudadDestino", cascade = CascadeType.ALL)
    private List<Ruta> rutasLlegada;

    public Ciudad() {}

    public Ciudad(String nombre, BigDecimal impuestos) {
        this.nombre = nombre;
        this.impuestos = impuestos.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getImpuestos() { return impuestos; }
    public void setImpuestos(BigDecimal impuestos) { 
        this.impuestos = impuestos.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public List<Ruta> getRutasSalida() { return rutasSalida; }
    public List<Ruta> getRutasLlegada() { return rutasLlegada; }
=======
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private Float impuestos;

    // Relaciones con las otras clases
    @OneToMany(mappedBy = "ciudadOrigen", cascade = CascadeType.ALL)
    private List<Ruta> rutasSalida;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL)
    private List<Producto> productos;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL)
    private List<Servicio> servicios;
    
    // Constructores    
    public Ciudad() {}

    public Ciudad(String nombre, Float impuestos) {
        this.nombre = nombre;
        this.impuestos = impuestos;
    }

    // Setters y getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String ciudad) {
        this.nombre = ciudad;
    }

    public Float getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Float impuestos) {
        this.impuestos = impuestos;
    }

    //

    public List<Ruta> getRutasSalida() {
        return rutasSalida;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

>>>>>>> main
}
