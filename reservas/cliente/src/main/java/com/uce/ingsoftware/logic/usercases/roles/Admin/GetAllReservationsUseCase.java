package com.uce.ingsoftware.logic.usercases.roles.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uce.ingsoftware.data.entities.ReservaEntity;
import com.uce.ingsoftware.data.repositories.ReservaRepository;

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

