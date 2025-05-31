package com.example.demo.dto;

public class RolDTO {

    private Long id;
    private String rolTipo; 
    public RolDTO() {}

    public RolDTO(Long id, String rolTipo) {
        this.id = id;
        this.rolTipo = rolTipo;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolTipo() {
        return rolTipo;
    }

    public void setRolTipo(String rolTipo) {
        this.rolTipo = rolTipo;
    }
}
