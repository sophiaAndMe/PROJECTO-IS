package com.uce.ingsoftware.logic.usercases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uce.ingsoftware.entities.ReservaEntity;
import com.uce.ingsoftware.repositories.ReservaRepository;



@Service
public class GetAllReservationsUseCase {

    private final ReservaRepository reservaRepository;

    public GetAllReservationsUseCase(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaEntity> execute() {
        // Ahora Luis recibe la agenda perfectamente organizada (RF-04)
        return reservaRepository.findAllByOrderByFechaReservaAscHoraReservaAsc();
    }
}

