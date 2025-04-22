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

    // Relaciones
    @OneToMany(mappedBy = "ciudadOrigen")
    private List<Ruta> rutasSalida;

    @OneToMany(mappedBy = "ciudadDestino")
    private List<Ruta> rutasLlegada;

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
}
