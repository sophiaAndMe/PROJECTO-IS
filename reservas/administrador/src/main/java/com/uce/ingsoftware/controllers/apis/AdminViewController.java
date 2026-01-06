package com.uce.ingsoftware.controllers.apis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.ingsoftware.logic.usercases.GetAllReservationsUseCase;



@Controller
@RequestMapping("/admin")
public class AdminViewController {
    
    private final GetAllReservationsUseCase getAllReservationsUseCase;

    public AdminViewController(GetAllReservationsUseCase getAllReservationsUseCase) {
        this.getAllReservationsUseCase = getAllReservationsUseCase;
    }

    // devuelva las reservas 
    @RequestMapping("/reservas")
    public String listaReserva(Model model) {
        model.addAttribute("reservas", getAllReservationsUseCase.execute());
        return "lista-reservas";
    }
}
