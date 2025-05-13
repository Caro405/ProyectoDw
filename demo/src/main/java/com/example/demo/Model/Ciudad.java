package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;


@Entity
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;
    
    private String nombre;
    private Integer impuestos;

    // Relaciones
    @OneToMany(mappedBy = "ciudad")
    private List<Producto> productos;

    @OneToMany(mappedBy = "ciudadOrigen")
    private List<Ruta> rutasSalida = new ArrayList<>();  // Inicializar la lista de rutasSalida

    @OneToMany(mappedBy = "ciudadDestino")
    private List<Ruta> rutasLlegada = new ArrayList<>();  // Inicializar la lista de rutasLlegada

    @OneToMany(mappedBy = "ciudad")
    private List<Servicio> servicios;

    public Ciudad() {}

    public Ciudad(String nombre, Integer impuestos) {
        this.nombre = nombre;
        this.impuestos = impuestos;
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

    public Integer getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Integer impuestos) {
        this.impuestos = impuestos;
    }

    public List<Ruta> getRutasSalida() {
        return rutasSalida;
    }

    public void setRutasSalida(List<Ruta> rutasSalida) {
        this.rutasSalida = rutasSalida;
    }

    public List<Ruta> getRutasLlegada() {
        return rutasLlegada;
    }

    public void setRutasLlegada(List<Ruta> rutasLlegada) {
        this.rutasLlegada = rutasLlegada;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

}
