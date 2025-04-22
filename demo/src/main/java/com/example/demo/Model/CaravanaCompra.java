package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import com.example.demo.Model.Jugador;


@Entity
public class CaravanaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo;
    private Integer cantidad;
    private Integer precio_unitario;    

    @ManyToOne
    private Caravana caravana;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Ciudad ciudad;

    public CaravanaCompra() {
    }

    public CaravanaCompra( Integer cantidad, Integer precio_unitario, Caravana caravana, Producto producto,
            Ciudad ciudad) {
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.caravana = caravana;
        this.producto = producto;
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Integer precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Caravana getCaravana() {
        return caravana;
    }

    public void setCaravana(Caravana caravana) {
        this.caravana = caravana;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }  
     
}
