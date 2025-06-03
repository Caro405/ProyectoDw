package com.example.demo.dto;

public class ServicioCiudadDTO {
    private Long id;
    private Integer precio;
    private Long servicioId;
    private Long ciudadId;

    public ServicioCiudadDTO() {}

    public ServicioCiudadDTO(Long id, Integer precio, Long servicioId, Long ciudadId) {
        this.id = id;
        this.precio = precio;
        this.servicioId = servicioId;
        this.ciudadId = ciudadId;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getPrecio() { return precio; }
    public void setPrecio(Integer precio) { this.precio = precio; }

    public Long getServicioId() { return servicioId; }
    public void setServicioId(Long servicioId) { this.servicioId = servicioId; }

    public Long getCiudadId() { return ciudadId; }
    public void setCiudadId(Long ciudadId) { this.ciudadId = ciudadId; }
}
