package com.example.demo.Model;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Ciudad {

    @Id
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
}
