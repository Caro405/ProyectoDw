package com.example.demo.dto;

public class ServicioDTO {

    private Long id;
    private String nombreservicio;
    private Integer precio;
    private Integer porcentajeEfecto;
    private Long ciudadId; // El ID de la ciudad asociada al servicio

    // Constructor por defecto
    public ServicioDTO() {}

    // Constructor con parámetros
    public ServicioDTO(Long id, String nombreservicio, Integer precio, Integer porcentajeEfecto, Long ciudadId) {
        this.id = id;
        this.nombreservicio = nombreservicio;
        this.precio = precio;
        this.porcentajeEfecto = porcentajeEfecto;
        this.ciudadId = ciudadId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreservicio() {
        return nombreservicio;
    }

    public void setNombreservicio(String nombreservicio) {
        this.nombreservicio = nombreservicio;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getPorcentajeEfecto() {
        return porcentajeEfecto;
    }

    public void setPorcentajeEfecto(Integer porcentajeEfecto) {
        this.porcentajeEfecto = porcentajeEfecto;
    }

    public Long getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Long ciudadId) {
        this.ciudadId = ciudadId;
    }
}
