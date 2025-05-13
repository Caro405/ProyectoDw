package com.example.demo.dto;

import java.sql.Date;

public class SesionJuegoDTO {

    private Long id;
    private String nombre;
    private Integer oro_maximo;
    private Date fecha_inicio;
    private Date fecha_fin;

    public SesionJuegoDTO() {}

    public SesionJuegoDTO(Long id, String nombre, Integer oro_maximo, Date fecha_inicio, Date fecha_fin) {
        this.id = id;
        this.nombre = nombre;
        this.oro_maximo = oro_maximo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
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

    public Integer getOro_maximo() {
        return oro_maximo;
    }

    public void setOro_maximo(Integer oro_maximo) {
        this.oro_maximo = oro_maximo;
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
}
