package com.example.demo.Model;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
//import java.util.List;

@Entity
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private Integer impuestos;

    // Relaciones
    @OneToMany(mappedBy = "ciudadOrigen", cascade = CascadeType.ALL)
    private List<Ruta> rutasSalida;

    @OneToMany(mappedBy = "ciudadDestino", cascade = CascadeType.ALL)
    private List<Ruta> rutasLlegada;

    @OneToMany(mappedBy = "ciudad")
    private List<ProductoCiudad> productoCiudades = new ArrayList<>();

    @OneToMany(mappedBy = "ciudad")
    private List<ServicioCiudad> servicioCiudades = new ArrayList<>();

    @OneToMany(mappedBy = "ciudad")
    private List<CaravanaCompra> caravanaCompra = new ArrayList<>();

    public Ciudad() {}

    
    public Ciudad(String nombre, Integer impuestos) {
        this.nombre = nombre;
        this.impuestos = impuestos;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getImpuestos() { return impuestos; }
    public void setImpuestos(Integer impuestos) { 
        this.impuestos = impuestos;
    }

    public List<Ruta> getRutasSalida() { return rutasSalida; }

    public List<Ruta> getRutasLlegada() { return rutasLlegada; }

    public List<ProductoCiudad> getProductoCiudades() { return productoCiudades;}

    public List<ServicioCiudad> getServicioCiudades() { return servicioCiudades; }

    public List<CaravanaCompra> getCaravanaCompra() { return caravanaCompra; }

}
