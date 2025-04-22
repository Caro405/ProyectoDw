package com.example.demo.Controller;

import com.example.demo.Service.ProductoService;
import com.example.demo.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.Service.CiudadService;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CiudadService ciudadService;

    // Listar productos
    @GetMapping("/list")
    public ModelAndView listarProductos() {
        List<ProductoDTO> productos = productoService.listarProductos();
        return new ModelAndView("producto-list").addObject("listaProductos", productos);
    }

    // Formulario para crear un producto
    @GetMapping("/create")
    public ModelAndView formularioCrearProducto() {
        // Usar valores predeterminados para crear un ProductoDTO
        return new ModelAndView("producto-edit")
                .addObject("producto", new ProductoDTO(0L, "", "", 0))  // Valores predeterminados
                .addObject("listaCiudades", ciudadService.listarCiudades());
    }

    // Guardar producto
    @PostMapping("/save")
    public String guardarProducto(@ModelAttribute ProductoDTO productoDTO) {
        productoService.guardarProducto(productoDTO);  
        return "redirect:/producto/list"; 
    }

    // Eliminar producto
    @GetMapping("/delete/{id}")
    public String borrarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);  
        return "redirect:/producto/list"; 
    }

    // Ver detalles de un producto
    @GetMapping("/view/{id}")
    public ModelAndView verProducto(@PathVariable Long id) {
        Optional<ProductoDTO> productoDTO = productoService.obtenerProductoPorId(id);
        if (productoDTO.isEmpty()) {
            return new ModelAndView("redirect:/producto/list");
        }
        return new ModelAndView("producto-view").addObject("producto", productoDTO.get());
    }

    // Formulario para editar un producto
    @GetMapping("/edit/{id}")
    public ModelAndView formularioEditarProducto(@PathVariable Long id) {
        Optional<ProductoDTO> productoDTO = productoService.obtenerProductoPorId(id);
        if (productoDTO.isEmpty()) {
            return new ModelAndView("redirect:/producto/list");
        }
        return new ModelAndView("producto-edit")
                .addObject("producto", productoDTO.get())
                .addObject("listaCiudades", ciudadService.listarCiudades());
    }
}
