package com.example.demo.dto;

import java.util.Objects;

public class ProductoCiudadDTO {

    private Long id;
    private Integer precio;
    private Integer factorDemanda;
    private Integer factorOferta;
    private Integer stock;
    private Long productoId;
    private Long ciudadId;

    public ProductoCiudadDTO() {}

    public ProductoCiudadDTO(Long id, Integer precio, Integer factorDemanda, Integer factorOferta,
                             Integer stock, Long productoId, Long ciudadId) {
        this.id = id;
        this.precio = precio;
        this.factorDemanda = factorDemanda;
        this.factorOferta = factorOferta;
        this.stock = stock;
        this.productoId = productoId;
        this.ciudadId = ciudadId;
    }

    // Getters y setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getPrecio() { return precio; }
    public void setPrecio(Integer precio) { this.precio = precio; }

    public Integer getFactorDemanda() { return factorDemanda; }
    public void setFactorDemanda(Integer factorDemanda) { this.factorDemanda = factorDemanda; }

    public Integer getFactorOferta() { return factorOferta; }
    public void setFactorOferta(Integer factorOferta) { this.factorOferta = factorOferta; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public Long getCiudadId() { return ciudadId; }
    public void setCiudadId(Long ciudadId) { this.ciudadId = ciudadId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoCiudadDTO)) return false;
        ProductoCiudadDTO that = (ProductoCiudadDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
