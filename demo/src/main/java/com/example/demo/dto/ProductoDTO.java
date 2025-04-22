package com.example.demo.dto;

import com.example.demo.dto.JugadorDTO;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.CiudadDTO;
import com.example.demo.dto.ServicioDTO;

import com.example.demo.Model.Jugador;
import com.example.demo.Model.Producto;
import com.example.demo.Model.Ciudad;
import com.example.demo.Model.Servicio;

public class ProductoDTO {

    private Long id;
    private String nombre;
    private String categoria;


    public ProductoDTO() {}

    public ProductoDTO(Long id, String nombre, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

}
