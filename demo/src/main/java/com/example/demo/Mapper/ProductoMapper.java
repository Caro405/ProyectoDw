package com.example.demo.Mapper;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.Model.Producto;
import com.example.demo.Model.Jugador;


public class ProductoMapper {

    // Convertir de Producto a ProductoDTO
    public static ProductoDTO toDTO(Producto producto) {
        return new ProductoDTO(
            producto.getId(),
            producto.getNombre(),
            producto.getCategoria().name()
        
        );
    }

    // Convertir de ProductoDTO a Producto
    public static Producto toEntity(ProductoDTO productoDTO) {
       
        // Convierte el String de categoria a el enum correspondiente
        Producto.Categoria categoria = Producto.Categoria.valueOf(productoDTO.getCategoria());
        
        return new Producto(
            productoDTO.getNombre(),
            null,
            0,
            0,
            0,
            null 
        );
    }
}
