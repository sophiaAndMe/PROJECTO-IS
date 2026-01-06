package com.uce.ingsoftware.controllers.apis;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uce.ingsoftware.entities.MesaEntity;
import com.uce.ingsoftware.DTOs.ReservaRequestDTO;
import com.uce.ingsoftware.logic.usercases.roles.User.CheckAvailabilityUserCase;
import com.uce.ingsoftware.logic.usercases.roles.User.MakeReservationUserCase;
import com.uce.ingsoftware.logic.usercases.UpdateReservationStatusUseCase;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final MakeReservationUserCase makeReservationUserCase;
    private final CheckAvailabilityUserCase checkAvailabilityUserCase; // <--- Agrega esta inyección
    private final UpdateReservationStatusUseCase updateReservationStatusUseCase;

    public ReservaController(MakeReservationUserCase makeReservationUseCase,
         CheckAvailabilityUserCase checkAvailabilityUserCase,
         UpdateReservationStatusUseCase updateReservationStatusUseCase) {

        this.makeReservationUserCase = makeReservationUseCase;
        this.checkAvailabilityUserCase = checkAvailabilityUserCase;
        this.updateReservationStatusUseCase = updateReservationStatusUseCase;
    }


    // Cumple con el CDU-02: Consultar disponibilidad 
    @GetMapping("/disponibilidad")
    public ResponseEntity<?> consultarDisponibilidad(
            @RequestParam (name = "fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @RequestParam (name = "hora") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime hora,
            @RequestParam (name = "comensales") int comensales) {
        try {
            List<MesaEntity> disponibles = checkAvailabilityUserCase.execute(fecha, hora, comensales);
            return ResponseEntity.ok(disponibles);
        } catch (RuntimeException e) {
            // Envía el mensaje de error "No hay disponibilidad" requerido [cite: 59, 71]
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Cumple con el RF-02 y CDU-05: Crear reserva [cite: 44, 74]
    @PostMapping
    public String crear(@RequestBody ReservaRequestDTO request) {
        return makeReservationUserCase.execute(request);
    }

   @PatchMapping("/{id}/estado")
    public ResponseEntity<String> actualizarEstado(
        // Agregamos (name = "id") para que Spring sepa qué buscar en la URL
        @PathVariable(name = "id") String id, 
        // Agregamos (name = "nuevoEstado") para que Spring sepa qué buscar en el parámetro
        @RequestParam(name = "nuevoEstado") String nuevoEstado) {
    
    updateReservationStatusUseCase.execute(id, nuevoEstado);
    return ResponseEntity.ok("Estado actualizado a " + nuevoEstado);
    }


}