package com.example.demo.dto;

import java.util.List;

public class CiudadDTO {

    private Long id;
    private String nombre;
    private Integer impuestos;
    private List<RutaDTO> rutasSalida;
    private List<RutaDTO> rutasLlegada;
    private List<ProductoDTO> productos;  

    public CiudadDTO() {}

    public CiudadDTO(Long id, String nombre, Integer impuestos, List<RutaDTO> rutasSalida, List<RutaDTO> rutasLlegada, List<ProductoDTO> productos) {
        this.id = id;
        this.nombre = nombre;
        this.impuestos = impuestos;
        this.rutasSalida = rutasSalida;
        this.rutasLlegada = rutasLlegada;
        this.productos = productos;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getImpuestos() { return impuestos; }
    public void setImpuestos(Integer impuestos) { this.impuestos = impuestos; }

    public List<RutaDTO> getRutasSalida() { return rutasSalida; }
    public void setRutasSalida(List<RutaDTO> rutasSalida) { this.rutasSalida = rutasSalida; }

    public List<RutaDTO> getRutasLlegada() { return rutasLlegada; }
    public void setRutasLlegada(List<RutaDTO> rutasLlegada) { this.rutasLlegada = rutasLlegada; }

    public List<ProductoDTO> getProductos() { return productos; }
    public void setProductos(List<ProductoDTO> productos) { this.productos = productos; }
}
