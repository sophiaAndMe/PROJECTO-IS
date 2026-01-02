package com.uce.ingsoftware.controllers.apis.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.ingsoftware.logic.usercases.roles.Admin.GetAllReservationsUseCase;

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
        return "admin/lista-reservas";
    }
}
