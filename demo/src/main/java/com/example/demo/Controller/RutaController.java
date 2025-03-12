package com.example.demo.Controller;

import com.example.demo.dto.RutaDTO;
//import com.example.demo.dto.CiudadDTO;
import com.example.demo.Service.RutaService;
import com.example.demo.Service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ruta")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @Autowired
    private CiudadService ciudadService;

    // Listar todas las rutas
    @GetMapping("/list")
    public ModelAndView listarRutas() {
        List<RutaDTO> rutas = rutaService.listarRutas();
        ModelAndView modelAndView = new ModelAndView("ruta-list");
        modelAndView.addObject("listaRutas", rutas);
        return modelAndView;
    }

    // Formulario para crear una nueva ruta
    @GetMapping("/create")
    public ModelAndView formularioCrearRuta() {
        ModelAndView modelAndView = new ModelAndView("ruta-edit");
        modelAndView.addObject("ruta", new RutaDTO());
        modelAndView.addObject("listaCiudades", ciudadService.listarCiudades());
        return modelAndView;
    }

    // Ver detalles de una ruta
    @GetMapping("/view/{id}")
    public ModelAndView verRuta(@PathVariable Long id) {
        Optional<RutaDTO> ruta = rutaService.obtenerRutaPorId(id);
        if (ruta.isEmpty()) {
            return new ModelAndView("redirect:/ruta/list");
        }
        return new ModelAndView("ruta-view").addObject("ruta", ruta.get());
    }

    // Formulario para editar una ruta
    @GetMapping("/edit/{id}")
    public ModelAndView formularioEditarRuta(@PathVariable Long id) {
        Optional<RutaDTO> rutaDTO = rutaService.obtenerRutaPorId(id);
        if (rutaDTO.isEmpty()) {
            return new ModelAndView("redirect:/ruta/list");
        }

        ModelAndView modelAndView = new ModelAndView("ruta-edit");
        modelAndView.addObject("ruta", rutaDTO.get());
        modelAndView.addObject("listaCiudades", ciudadService.listarCiudades());
        return modelAndView;
    }

    // Guardar ruta (crear o actualizar)
    @PostMapping("/save")
    public RedirectView guardarRuta(@ModelAttribute RutaDTO rutaDTO) {
        rutaService.guardarRuta(rutaDTO);
        return new RedirectView("/ruta/list");
    }

    // Eliminar ruta
    @GetMapping("/delete/{id}")
    public RedirectView borrarRuta(@PathVariable Long id) {
        rutaService.eliminarRuta(id);
        return new RedirectView("/ruta/list");
    }
}

