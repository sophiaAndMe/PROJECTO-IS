package com.uce.ingsoftware.logic.usercases.roles.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uce.ingsoftware.entities.MesaEntity;
import com.uce.ingsoftware.repositories.MesaRepository;

@Service
public class CheckAvailabilityUserCase {

    // Inyectando el repositorio de mesas
    private final MesaRepository mesaRepository;

    public CheckAvailabilityUserCase(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }


    // metodo que me devuelva un lista de mesas disponibles
    public List<MesaEntity> execute(LocalDate fecha, LocalTime hora, int comensales) {

        if(fecha.isBefore(LocalDate.now())){
            throw new RuntimeException("La fecha no puede ser anterior a la fecha actual");
        }
        
        List<MesaEntity> disponibles = mesaRepository.findAvailableTables(fecha, hora, comensales);

        if(disponibles.isEmpty()){
            throw new RuntimeException("No hay mesas disponibles para la fecha y hora seleccionadas");
        }

        return disponibles;
    }

}
