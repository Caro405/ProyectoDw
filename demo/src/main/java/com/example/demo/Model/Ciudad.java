package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private Integer impuestos;

    @OneToMany(mappedBy = "ciudad")
    private List<Ruta> rutas;

    @OneToMany(mappedBy = "ciudad")
    private List<Servicio> servicios;

    public Ciudad() {}

    public Ciudad(String nombre, Integer impuestos) {
        this.nombre = nombre;
        this.impuestos = impuestos;
    }

    // Getters and Setters
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

    

    public List<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Integer getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Integer impuestos) {
        this.impuestos = impuestos;
    }


}
