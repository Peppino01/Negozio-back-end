package com.grammatico.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.Dipendente;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    
}
