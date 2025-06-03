package com.example.demo.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private Integer impuestos;

    @OneToMany(mappedBy = "ciudadOrigen")
    private List<Ruta> rutasSalida = new ArrayList<>();

    @OneToMany(mappedBy = "ciudadDestino")
    private List<Ruta> rutasLlegada = new ArrayList<>();

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoCiudad> productosCiudad = new ArrayList<>();

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServicioCiudad> serviciosCiudad = new ArrayList<>();

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
    public void setImpuestos(Integer impuestos) { this.impuestos = impuestos; }

    public List<Ruta> getRutasSalida() { return rutasSalida; }
    public void setRutasSalida(List<Ruta> rutasSalida) { this.rutasSalida = rutasSalida; }

    public List<Ruta> getRutasLlegada() { return rutasLlegada; }
    public void setRutasLlegada(List<Ruta> rutasLlegada) { this.rutasLlegada = rutasLlegada; }

    public List<ProductoCiudad> getProductosCiudad() { return productosCiudad; }
    public void setProductosCiudad(List<ProductoCiudad> productosCiudad) { this.productosCiudad = productosCiudad; }

    public List<ServicioCiudad> getServiciosCiudad() { return serviciosCiudad; }
    public void setServiciosCiudad(List<ServicioCiudad> serviciosCiudad) { this.serviciosCiudad = serviciosCiudad; }
}
