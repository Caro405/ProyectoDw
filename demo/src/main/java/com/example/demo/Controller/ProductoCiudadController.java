package com.example.demo.Controller;

import com.example.demo.Service.ProductoCiudadService;
import com.example.demo.Service.ProductoService;
import com.example.demo.Service.CiudadService;
import com.example.demo.dto.ProductoCiudadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/productoCiudad")
public class ProductoCiudadController {

    @Autowired
    private ProductoCiudadService productoCiudadService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CiudadService ciudadService;

    // ✅ Listar todas las relaciones producto-ciudad
    @GetMapping("/list")
    public ModelAndView listarProductoCiudad() {
        List<ProductoCiudadDTO> lista = productoCiudadService.listarTodas();
        return new ModelAndView("productoCiudad-list").addObject("listaProductoCiudad", lista);
    }

    // ✅ Formulario para crear nueva relación producto-ciudad
    @GetMapping("/create")
    public ModelAndView formularioCrearRelacion() {
        return new ModelAndView("productoCiudad-edit")
                .addObject("productoCiudad", new ProductoCiudadDTO())
                .addObject("listaProductos", productoService.listarProductos())
                .addObject("listaCiudades", ciudadService.listarCiudades());
    }

    // ✅ Guardar o actualizar relación
    @PostMapping("/save")
    public String guardarRelacion(@ModelAttribute ProductoCiudadDTO productoCiudadDTO) {
        productoCiudadService.guardar(productoCiudadDTO);
        return "redirect:/productoCiudad/list";
    }

    // Ver detalles
    @GetMapping("/view/{id}")
    public ModelAndView verRelacion(@PathVariable Long id) {
        Optional<ProductoCiudadDTO> dto = productoCiudadService.obtenerPorId(id);
        if (dto.isEmpty()) {
            return new ModelAndView("redirect:/productoCiudad/list");
        }
        return new ModelAndView("productoCiudad-view").addObject("productoCiudad", dto.get());
    }

    // ✅ Formulario editar
    @GetMapping("/edit/{id}")
    public ModelAndView editarRelacion(@PathVariable Long id) {
        Optional<ProductoCiudadDTO> dto = productoCiudadService.obtenerPorId(id);
        if (dto.isEmpty()) {
            return new ModelAndView("redirect:/productoCiudad/list");
        }
        return new ModelAndView("productoCiudad-edit")
                .addObject("productoCiudad", dto.get())
                .addObject("listaProductos", productoService.listarProductos())
                .addObject("listaCiudades", ciudadService.listarCiudades());
    }

    // ✅ Eliminar
    @GetMapping("/delete/{id}")
    public String eliminarRelacion(@PathVariable Long id) {
        productoCiudadService.eliminar(id);
        return "redirect:/productoCiudad/list";
    }
}
