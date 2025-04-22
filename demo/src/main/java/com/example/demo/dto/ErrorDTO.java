package com.example.demo.dto;

import com.example.demo.dto.JugadorDTO;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.CiudadDTO;
import com.example.demo.dto.ServicioDTO;

import com.example.demo.Model.Jugador;
import com.example.demo.Model.Producto;
import com.example.demo.Model.Ciudad;
import com.example.demo.Model.Servicio;

import com.example.demo.dto.ErrorDTO;

public class ErrorDTO {
    private String errorString;

    public ErrorDTO(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
