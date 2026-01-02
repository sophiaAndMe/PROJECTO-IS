package com.uce.ingsoftware.logic.usercases.roles.Admin;

import com.uce.ingsoftware.data.repositories.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateReservationStatusUseCase {

    private final ReservaRepository reservaRepository;

    public UpdateReservationStatusUseCase(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Transactional
    public void execute(String reservaId, String nuevoEstado) {
        var reserva = reservaRepository.findById(reservaId)
            .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        
        reserva.setEstadoReserva(nuevoEstado);
        reservaRepository.save(reserva);
    }
}