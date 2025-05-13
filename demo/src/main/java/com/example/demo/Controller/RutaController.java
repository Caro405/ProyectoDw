package com.example.demo.Controller;

import com.example.demo.Service.RutaService;  
import com.example.demo.Service.CiudadService;  
import com.example.demo.dto.RutaDTO;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;  
import org.springframework.web.servlet.ModelAndView;  

// Asegúrate de importar estas clases
import java.util.List;  // Importar List correctamente
import java.util.Optional;  // Importar Optional correctamente

@RestController
@RequestMapping("/ruta")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @Autowired
    private CiudadService ciudadService;

    // Listar rutas
    @GetMapping("/list")
    public ModelAndView listarRutas() {
        List<RutaDTO> rutas = rutaService.listarRutas();
        return new ModelAndView("ruta-list").addObject("listaRutas", rutas);
    }

    // Formulario para crear una ruta
    @GetMapping("/create")
    public ModelAndView formularioCrearRuta() {
        return new ModelAndView("ruta-edit")
                .addObject("ruta", new RutaDTO())
                .addObject("listaCiudades", ciudadService.getAllCiudades());
    }

    // Guardar ruta
    @PostMapping("/save")
    public String guardarRuta(@ModelAttribute RutaDTO rutaDTO) {
        rutaService.guardarRuta(rutaDTO);  
        return "redirect:/ruta/list";  
    }

    // Eliminar ruta
    @GetMapping("/delete/{id}")
    public String borrarRuta(@PathVariable Long id) {
        rutaService.eliminarRuta(id); 
        return "redirect:/ruta/list"; 
    }

    // Ver detalles de una ruta
    @GetMapping("/view/{id}")
    public ModelAndView verRuta(@PathVariable Long id) {
        Optional<RutaDTO> rutaDTO = rutaService.obtenerRutaPorId(id);
        if (rutaDTO.isEmpty()) {
            return new ModelAndView("redirect:/ruta/list");
        }
        return new ModelAndView("ruta-view").addObject("ruta", rutaDTO.get());
    }

    // Formulario para editar una ruta
    @GetMapping("/edit/{id}")
    public ModelAndView formularioEditarRuta(@PathVariable Long id) {
        Optional<RutaDTO> rutaDTO = rutaService.obtenerRutaPorId(id);
        if (rutaDTO.isEmpty()) {
            return new ModelAndView("redirect:/ruta/list");
        }
        return new ModelAndView("ruta-edit")
                .addObject("ruta", rutaDTO.get())
                .addObject("listaCiudades", ciudadService.getAllCiudades());
    }
}
