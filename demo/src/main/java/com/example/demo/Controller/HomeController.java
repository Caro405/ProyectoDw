package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")  // Página principal
    public String mostrarInicio() {
        return "inicio-view";  // Coincide con el nombre del archivo en templates
    }
}
