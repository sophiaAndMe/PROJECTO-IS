package com.uce.ingsoftware.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ReservaRequestDTO(
    String nombreCliente,    // RF-02 [cite: 44]
    String telefono,         // RF-02 [cite: 44]
    String email,            // RF-02 [cite: 44]
    String mesaId,             // Para asignar la mesa [cite: 73]
    @JsonFormat(pattern = "yyyy-MM-dd") java.time.LocalDate fecha,         // HU-01 [cite: 49]
    @JsonFormat(pattern = "HH:mm:ss") java.time.LocalTime hora,          // HU-01 [cite: 49]
    int numeroComensales     // RF-06 [cite: 44]
) {


}