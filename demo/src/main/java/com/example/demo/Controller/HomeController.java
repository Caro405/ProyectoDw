package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/")  // Página principal
    public String mostrarInicio() {
        return "inicio-view"; 
    }
}
