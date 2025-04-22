package com.example.demo.Controller;

import com.example.demo.Service.JugadorService;
import com.example.demo.dto.JugadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;




@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/")  // Página principal
    public String mostrarInicio() {
        return "inicio-view";  // Devuelve la vista inicio-view.html (si usas Thymeleaf)
    }
}
