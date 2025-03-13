package com.example.demo.Controller;

import com.example.demo.dto.CiudadDTO;
import com.example.demo.Service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ciudad")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    // Listar todas las ciudades
    @GetMapping("/list")
    public ModelAndView listarCiudades() {
        List<CiudadDTO> ciudades = ciudadService.listarCiudades();
        ModelAndView modelAndView = new ModelAndView("ciudad-list");
        modelAndView.addObject("listaCiudades", ciudades);
        return modelAndView;
    }

    // Formulario para crear una nueva ciudad
    @GetMapping("/create")
    public ModelAndView formularioCrearCiudad() {
        return new ModelAndView("ciudad-edit")
                .addObject("ciudad", new CiudadDTO());
    }

    // Ver detalles de una ciudad
    @GetMapping("/view/{id}")
    public ModelAndView verCiudad(@PathVariable Long id) {
        Optional<CiudadDTO> ciudad = ciudadService.obtenerCiudadPorId(id);
        if (ciudad.isEmpty()) {
            return new ModelAndView("redirect:/ciudad/list");
        }
        return new ModelAndView("ciudad-view").addObject("ciudad", ciudad.get());
    }

    // Formulario para editar una ciudad
    @GetMapping("/edit/{id}")
    public ModelAndView formularioEditarCiudad(@PathVariable Long id) {
        Optional<CiudadDTO> ciudadDTO = ciudadService.obtenerCiudadPorId(id);
        if (ciudadDTO.isEmpty()) {
            return new ModelAndView("redirect:/ciudad/list");
        }
        return new ModelAndView("ciudad-edit").addObject("ciudad", ciudadDTO.get());
    }

    
    // Guardar ciudad (crear o actualizar)
    @PostMapping("/save")
    public String guardarCiudad(@ModelAttribute CiudadDTO ciudadDTO) {
        ciudadService.guardarCiudad(ciudadDTO);
        return "redirect:/ciudad/list"; 
}

    @GetMapping("/delete/{id}")
        public String borrarCiudad(@PathVariable Long id) {
        ciudadService.eliminarCiudad(id);
        return "redirect:/ciudad/list"; 
}

}

