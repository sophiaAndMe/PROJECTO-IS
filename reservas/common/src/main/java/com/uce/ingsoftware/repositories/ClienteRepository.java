package com.uce.ingsoftware.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uce.ingsoftware.entities.ClienteEntity;


public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByEmail(String email); // Para no duplicar clientes
}
