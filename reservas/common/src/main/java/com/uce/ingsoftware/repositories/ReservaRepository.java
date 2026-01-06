package com.uce.ingsoftware.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;

import com.uce.ingsoftware.entities.ReservaEntity;


@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, String>{
    
    // Spring genera: ORDER BY fecha_reserva ASC, hora_reserva ASC
    List<ReservaEntity> findAllByOrderByFechaReservaAscHoraReservaAsc();

    
}
