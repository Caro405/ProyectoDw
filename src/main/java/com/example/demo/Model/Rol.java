package com.example.demo.Model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol_tipo", nullable = false, unique = true)
    private RolTipo rolTipo;

    public Rol() {}

    public Rol(RolTipo rolTipo) {
        this.rolTipo = rolTipo;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolTipo getRolTipo() {
        return rolTipo;
    }

    public void setRolTipo(RolTipo rolTipo) {
        this.rolTipo = rolTipo;
    }
}
