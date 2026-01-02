package com.uce.ingsoftware.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@Builder
@Getter 
@Setter
@NoArgsConstructor  
@AllArgsConstructor
@Entity
public class ReservaEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String reservaId; // Identificador único de la reserva
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;


    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private MesaEntity mesa;


    private java.time.LocalDate fechaReserva; // HU-01
    private java.time.LocalTime horaReserva; // HU-01
    

   @Column(name = "numero_comensales", nullable = false)
    private Integer comesales; // Requisito RF-02

    @Column(columnDefinition = "varchar(255) default 'PENDIENTE'")
    private String estadoReserva;
    
}
