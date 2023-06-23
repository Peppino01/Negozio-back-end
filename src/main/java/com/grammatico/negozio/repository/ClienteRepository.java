package com.grammatico.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
