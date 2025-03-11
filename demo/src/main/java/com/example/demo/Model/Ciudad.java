package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ciudad {

    @Id
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

}
