package com.uce.ingsoftware.logic.usercases;

import com.uce.ingsoftware.repositories.ReservaRepository;
import com.uce.ingsoftware.services.EmailService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateReservationStatusUseCase {

    private final ReservaRepository reservaRepository;
    private final EmailService emailService;

    public UpdateReservationStatusUseCase(ReservaRepository reservaRepository, EmailService emailService) {
        this.reservaRepository = reservaRepository;
        this.emailService = emailService;
    }


    // Dentro de UpdateReservationStatusUseCase.java
    @Transactional
    public void execute(String reservaId, String nuevoEstado) {
    // 1. Buscamos la reserva
    var reserva = reservaRepository.findById(reservaId)
        .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    
    // 2. Actualizamos el estado en la base de datos
    reserva.setEstadoReserva(nuevoEstado);
    reservaRepository.save(reserva);

    // 3. RF-03: Notificación condicional
    if ("CONFIRMADA".equalsIgnoreCase(nuevoEstado)) {
        String mensaje = String.format(
            "¡Hola %s!\n\nTu reserva en 'El Buen Sabor' ha sido CONFIRMADA.\n" +
            "Detalles:\n- Fecha: %s\n- Hora: %s\n\n¡Te esperamos!",
            reserva.getCliente().getNombre(),
            reserva.getFechaReserva(),
            reserva.getHoraReserva()
        );
        
        emailService.enviarNotificacion(
            reserva.getCliente().getEmail(),
            "Confirmación de Reserva - El Buen Sabor",
            mensaje
        );
        }
    }   


    
}