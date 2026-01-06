package com.uce.ingsoftware.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mesas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MesaEntity {
    
    @Id
    @Column(name = "mesa_id")
    private String mesaId;
 
    @Column(name = "numero_mesa", unique = true, nullable = false)
    private int numeroMesa;

    
    private int capacidadMesa; // Validar RF-06

    private String ubicacion;

    private String estado; // DISPONIBLE, NO DISPONIBLE



}
