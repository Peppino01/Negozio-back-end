package com.grammatico.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.Recenzione;

public interface RecenzioneRepository extends JpaRepository<Recenzione, Long> {
    
}
