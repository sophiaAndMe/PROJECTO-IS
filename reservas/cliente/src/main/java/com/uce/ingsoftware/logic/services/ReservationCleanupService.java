package com.uce.ingsoftware.logic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import com.uce.ingsoftware.repositories.ReservaRepository;


public class ReservationCleanupService {

    private final ReservaRepository reservaRepository;
    private static final Logger log = LoggerFactory.getLogger(ReservationCleanupService.class);

    public ReservationCleanupService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // Programa la tarea para que se ejecute diariamente a la medianoche
    @Scheduled(fixedRate = 600000)
    @Transactional
    public void cleanupReservation(){

        log.info("Iniciando limpieza de reservas antiguas...");
        
        reservaRepository.deleteAll();

        log.info("Limpieza de reservas antiguas completada!");

    }


}
