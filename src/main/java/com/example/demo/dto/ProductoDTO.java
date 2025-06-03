package com.example.demo.dto;

import com.example.demo.Model.Producto;

import java.util.Objects;

public class ProductoDTO {

    private Long id;
    private String nombre;
    private Producto.Categoria categoria;
    private Integer precioBase;
    private Integer factorOferta;
    private Integer factorDemanda;
    private Long ciudadId;

    public ProductoDTO() {}

    public ProductoDTO(Long id, String nombre, Producto.Categoria categoria, Integer precioBase,
                       Integer factorOferta, Integer factorDemanda, Long ciudadId) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioBase = precioBase;
        this.factorOferta = factorOferta;
        this.factorDemanda = factorDemanda;
        this.ciudadId = ciudadId;
    }

    // Getters y setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Producto.Categoria getCategoria() { return categoria; }
    public void setCategoria(Producto.Categoria categoria) { this.categoria = categoria; }

    public Integer getPrecioBase() { return precioBase; }
    public void setPrecioBase(Integer precioBase) { this.precioBase = precioBase; }

    public Integer getFactorOferta() { return factorOferta; }
    public void setFactorOferta(Integer factorOferta) { this.factorOferta = factorOferta; }

    public Integer getFactorDemanda() { return factorDemanda; }
    public void setFactorDemanda(Integer factorDemanda) { this.factorDemanda = factorDemanda; }

    public Long getCiudadId() { return ciudadId; }
    public void setCiudadId(Long ciudadId) { this.ciudadId = ciudadId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoDTO)) return false;
        ProductoDTO that = (ProductoDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
