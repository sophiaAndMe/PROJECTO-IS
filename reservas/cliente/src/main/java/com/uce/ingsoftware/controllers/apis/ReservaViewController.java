package com.uce.ingsoftware.controllers.apis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservaViewController {


    // SOLO DEVUELVE VISTAS PARA TESTEO
    @GetMapping("/reserva")
    public String mostrarFormulario(){
        return "formulario-reserva";
    }

    
}
