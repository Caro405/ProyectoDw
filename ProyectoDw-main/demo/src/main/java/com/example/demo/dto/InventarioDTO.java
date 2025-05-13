package com.example.demo.dto;

public class InventarioDTO {

    private Long id;
    private String nombre;
    private Long caravanaId;

    public InventarioDTO() {}

    public InventarioDTO(Long id, String nombre, Long caravanaId) {
        this.id = id;
        this.nombre = nombre;
        this.caravanaId = caravanaId;
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

    public Long getCaravanaId() {
        return caravanaId;
    }

    public void setCaravanaId(Long caravanaId) {
        this.caravanaId = caravanaId;
    }
}
