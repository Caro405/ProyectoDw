package com.example.demo.Controller;

import com.example.demo.dto.RutaDTO;
import com.example.demo.Service.RutaService;
import com.example.demo.Service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ruta")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @Autowired
    private CiudadService ciudadService;

    @GetMapping("/list")
    public ModelAndView listarRutas() {
        List<RutaDTO> rutas = rutaService.listarRutas();
        return new ModelAndView("ruta-list").addObject("listaRutas", rutas);
    }

    @GetMapping("/create")
    public ModelAndView formularioCrearRuta() {
        return new ModelAndView("ruta-edit")
                .addObject("ruta", new RutaDTO())
                .addObject("listaCiudades", ciudadService.listarCiudades());
    }

    @PostMapping("/save")
    public String guardarRuta(@ModelAttribute RutaDTO rutaDTO) {
        rutaService.guardarRuta(rutaDTO);
        return "redirect:/ruta/list";
    }

    @GetMapping("/delete/{id}")
    public String borrarRuta(@PathVariable Long id) {
        rutaService.eliminarRuta(id);
        return "redirect:/ruta/list";
    }

    // 🔹 Ver detalles de una ruta
    @GetMapping("/view/{id}")
    public ModelAndView verRuta(@PathVariable Long id) {
        Optional<RutaDTO> rutaDTO = rutaService.obtenerRutaPorId(id);
        if (rutaDTO.isEmpty()) {
            return new ModelAndView("redirect:/ruta/list");
        }
        return new ModelAndView("ruta-view").addObject("ruta", rutaDTO.get());
    }

    // 🔹 Formulario para editar una ruta
    @GetMapping("/edit/{id}")
    public ModelAndView formularioEditarRuta(@PathVariable Long id) {
        Optional<RutaDTO> rutaDTO = rutaService.obtenerRutaPorId(id);
        if (rutaDTO.isEmpty()) {
            return new ModelAndView("redirect:/ruta/list");
        }
        return new ModelAndView("ruta-edit")
                .addObject("ruta", rutaDTO.get())
                .addObject("listaCiudades", ciudadService.listarCiudades());
    }
}
