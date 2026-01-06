package com.uce.ingsoftware.logic.usercases.roles.User;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.uce.ingsoftware.entities.ClienteEntity;
import com.uce.ingsoftware.entities.MesaEntity;
import com.uce.ingsoftware.entities.ReservaEntity;
import com.uce.ingsoftware.repositories.ClienteRepository;
import com.uce.ingsoftware.repositories.MesaRepository;
import com.uce.ingsoftware.repositories.ReservaRepository;
import com.uce.ingsoftware.DTOs.ReservaRequestDTO;

import jakarta.transaction.Transactional;



@Service
public class MakeReservationUserCase {

    
    private final ReservaRepository reservaRepository;
    // Necesitaremos buscar la mesa por ID
    private final MesaRepository mesaRepository; 
    private final ClienteRepository clienteRepository;

    public MakeReservationUserCase(ReservaRepository reservaRepository, 
        MesaRepository mesaRepository,
        ClienteRepository clienteRepository) {
        this.reservaRepository = reservaRepository;
        this.mesaRepository = mesaRepository;
        this.clienteRepository = clienteRepository;
    }


    @Transactional
    public String execute(ReservaRequestDTO request) {

        // Validación de seguridad: Si el ID es nulo, lanzamos una excepción controlada
        if (request.mesaId() == null) {
        throw new RuntimeException("Debe seleccionar una mesa válida de la lista.");
    }

        // El resto de tu lógica...
        mesaRepository.findByMesaId(request.mesaId())
            .orElseThrow(() -> new RuntimeException("La mesa seleccionada ya no existe."));
        // ...

        // 1. Buscar o crear al cliente (RF-02) 
        ClienteEntity cliente = clienteRepository.findByEmail(request.email())
            .orElseGet(() -> clienteRepository.save(
                ClienteEntity.builder()
                    .nombre(request.nombreCliente())
                    .email(request.email())
                    .telefono(request.telefono())
                    .build()
            ));

        // 2. Validar disponibilidad de mesa (RF-06) [cite: 44, 59]
        MesaEntity mesa = mesaRepository.findByMesaId(request.mesaId())
            .orElseThrow(() -> new RuntimeException("La mesa no existe"));

        if (request.numeroComensales() > mesa.getCapacidadMesa()) {
            throw new RuntimeException("La mesa seleccionada es muy pequeña para " + request.numeroComensales() + " personas.");
        }

        // 3. Crear la reserva (CDU-05) [cite: 74]
        ReservaEntity reserva = ReservaEntity.builder()
                .cliente(cliente)
                .mesa(mesa)
                .fechaReserva(request.fecha())
                .horaReserva(request.hora())
                .comesales(request.numeroComensales())
                .estadoReserva("PENDIENTE") // Flujo normal [cite: 74]
                .build();

        // validar que la mesa esté disponible en la fecha y hora solicitada
        

        return reservaRepository.save(reserva).getReservaId();
    }
}
