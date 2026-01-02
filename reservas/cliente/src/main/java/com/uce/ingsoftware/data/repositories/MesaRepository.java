package com.uce.ingsoftware.data.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uce.ingsoftware.data.entities.MesaEntity;

@Repository
public interface  MesaRepository extends JpaRepository<MesaEntity, Long> {

    // ¡Listo! Ya tienes métodos como save(), findAll(), deleteById(), etc.
    
    // Archivo: MesaRepository.java

    @Query("SELECT m FROM MesaEntity m WHERE m.capacidadMesa >= :comensales " +
       "AND m.mesaId NOT IN (SELECT r.mesa.mesaId FROM ReservaEntity r " + 
       "WHERE r.fechaReserva = :fecha AND r.horaReserva = :hora AND r.estadoReserva <> 'CANCELADA')")
    List<MesaEntity> findAvailableTables(
    @Param("fecha") LocalDate fecha, 
    @Param("hora") LocalTime hora, 
    @Param("comensales") int comensales
    );  

    Optional<MesaEntity> findByMesaId(String mesaId);
}
