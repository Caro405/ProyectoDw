package com.example.demo.Mapper;

import com.example.demo.Model.Producto;
import com.example.demo.dto.ProductoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductoMapper {

   
    ProductoDTO productoToProductoDTO(Producto producto);

    Producto productoDTOToProducto(ProductoDTO productoDTO);
}
