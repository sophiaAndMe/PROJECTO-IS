package com.uce.ingsoftware.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uce.ingsoftware.data.entities.ReservaEntity;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, String>{
    
    // Spring genera: ORDER BY fecha_reserva ASC, hora_reserva ASC
    List<ReservaEntity> findAllByOrderByFechaReservaAscHoraReservaAsc();
}
