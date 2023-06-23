package com.grammatico.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.Transazione;

public interface TransazioneRepository extends JpaRepository<Transazione, Long> {
    
}
