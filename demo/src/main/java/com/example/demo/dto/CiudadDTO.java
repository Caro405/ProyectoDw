package com.example.demo.dto;


public class CiudadDTO {
    private Long id;
    private String nombre;
    private Integer impuestos;

    public CiudadDTO() {}

    public CiudadDTO( String nombre, Integer impuestos) {
        this.nombre = nombre;
        this.impuestos = impuestos;
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
    

    
    public Integer getImpuestos() { return impuestos; }
    public void setImpuestos(Integer impuestos) { this.impuestos = impuestos;}

   
    
}
