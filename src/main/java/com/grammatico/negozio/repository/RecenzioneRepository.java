package com.grammatico.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.entity.Recenzione;

public interface RecenzioneRepository extends JpaRepository<Recenzione, Long> {
    
}
