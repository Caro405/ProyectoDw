package com.example.demo.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SesionJuego {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
 
    private Integer oro_maximo;
    private Date fecha_inicio;
    private Date fecha_fin;

    public SesionJuego(){}

    public SesionJuego(String nombre, Integer oro_maximo, Date fecha_inicio, Date fecha_fin) {
        this.nombre = nombre;
        this.oro_maximo=oro_maximo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Integer getOro_maximo() {
        return oro_maximo;
    }

    public void setOro_maximo(Integer oro_maximo) {
        this.oro_maximo = oro_maximo;
    }

}
