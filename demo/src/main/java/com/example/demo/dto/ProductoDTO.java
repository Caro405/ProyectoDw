package com.example.demo.dto;
import com.example.demo.dto.ProductoDTO;


public class ProductoDTO {

    private Long id;
    private String nombre;
    private String categoria;
    private Integer precioBase;

    // Constructor
    public ProductoDTO(Long id, String nombre, String categoria, Integer precioBase) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioBase = precioBase;
    }

    // Getters y setters
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Integer precioBase) {
        this.precioBase = precioBase;
    }
}
