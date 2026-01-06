package com.uce.ingsoftware.controllers.services;

import org.springframework.stereotype.Service;

import com.uce.ingsoftware.entities.ClienteEntity;
import com.uce.ingsoftware.entities.MesaEntity;



@Service
public class MakeReservationService {
    
    
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
