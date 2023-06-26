package com.grammatico.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.entity.Vendita;

public interface VenditaRepository extends JpaRepository<Vendita, Long> {
    
}
