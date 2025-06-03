package com.example.demo.dto;

import java.util.List;
import java.util.Objects;

public class InventarioDTO {

    private Long id;
    private String nombre;
    private Long caravanaId;

    private List<ProductoInventarioDTO> productosInventario;
    private List<ServicioInventarioDTO> serviciosInventario;

    public InventarioDTO() {}

    public InventarioDTO(Long id, String nombre, Long caravanaId,
                         List<ProductoInventarioDTO> productosInventario,
                         List<ServicioInventarioDTO> serviciosInventario) {
        this.id = id;
        this.nombre = nombre;
        this.caravanaId = caravanaId;
        this.productosInventario = productosInventario;
        this.serviciosInventario = serviciosInventario;
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

    public Long getCaravanaId() {
        return caravanaId;
    }

    public void setCaravanaId(Long caravanaId) {
        this.caravanaId = caravanaId;
    }

    public List<ProductoInventarioDTO> getProductosInventario() {
        return productosInventario;
    }

    public void setProductosInventario(List<ProductoInventarioDTO> productosInventario) {
        this.productosInventario = productosInventario;
    }

    public List<ServicioInventarioDTO> getServiciosInventario() {
        return serviciosInventario;
    }

    public void setServiciosInventario(List<ServicioInventarioDTO> serviciosInventario) {
        this.serviciosInventario = serviciosInventario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventarioDTO)) return false;
        InventarioDTO that = (InventarioDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
