package com.uce.ingsoftware.controllers.services;

import org.springframework.stereotype.Service;

import com.uce.ingsoftware.data.entities.ClienteEntity;
import com.uce.ingsoftware.data.entities.MesaEntity;
import com.uce.ingsoftware.logic.usercases.roles.User.MakeReservationUserCase;


@Service
public class MakeReservationService {
    
    
    private final MakeReservationUserCase userCase;

    
    // injectamos y esta atado al caso de uso
    public MakeReservationService(MakeReservationUserCase userCase) {
        this.userCase = userCase;
    }

    public String makeReservation(ClienteEntity cliente, 
        MesaEntity mesa, 
        java.time.LocalDateTime fechaReserva, 
        java.time.LocalTime horaReserva,
        int numeroComensales)
     {

        return null;
        //userCase.makeReservation(cliente, mesa, fechaReserva, horaReserva, numeroComensales);
    }


}
