package com.example.demo.dto;


import java.time.LocalDateTime;
import java.util.List;

public class VentaDTO {

    private Long id;
    private Long caravanaId;
    private Long ciudadId;
    private LocalDateTime fechaVenta;
    private Integer total;
    private List<DetalleVentaDTO> detalles;

    // Getters y setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCaravanaId() { return caravanaId; }
    public void setCaravanaId(Long caravanaId) { this.caravanaId = caravanaId; }

    public Long getCiudadId() { return ciudadId; }
    public void setCiudadId(Long ciudadId) { this.ciudadId = ciudadId; }

    public LocalDateTime getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(LocalDateTime fechaVenta) { this.fechaVenta = fechaVenta; }

    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }

    public List<DetalleVentaDTO> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVentaDTO> detalles) { this.detalles = detalles; }
}
