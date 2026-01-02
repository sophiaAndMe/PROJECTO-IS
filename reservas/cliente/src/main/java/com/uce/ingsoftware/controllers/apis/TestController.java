package com.uce.ingsoftware.controllers.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    

    @GetMapping("/")
    public String home() {
        return "Restaurante UCE - Servicio de Reservas Activo";
    }
    
}
