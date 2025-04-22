package com.example.demo.Mapper;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.Model.Producto;
import com.example.demo.Model.Jugador;
import com.example.demo.Model.Producto; 


public class ProductoMapper {

    /// Convertir de Producto a ProductoDTO
public static ProductoDTO toDTO(Producto producto) {
    return new ProductoDTO(
        producto.getId(),
        producto.getNombre(),
        producto.getCategoria().name(),
        producto.getPrecioBase()  // Asumiendo que el precioBase se obtiene de algún lado
    );
}

// Convertir de ProductoDTO a Producto
public static Producto toEntity(ProductoDTO productoDTO) {
    Producto.Categoria categoria = Producto.Categoria.valueOf(productoDTO.getCategoria());

    return new Producto(
        productoDTO.getNombre(),
        categoria,
        productoDTO.getPrecioBase(),  // Asegúrate de pasar el precioBase
        0,  // Factor oferta
        0,  // Factor demanda
        null // Ciudad asociada, si corresponde
    );
    }
}
