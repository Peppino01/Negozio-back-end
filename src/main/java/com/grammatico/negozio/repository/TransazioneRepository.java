package com.grammatico.negozio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.entity.Transazione;

public interface TransazioneRepository extends JpaRepository<Transazione, Long> {

    List<Transazione> findAllByOrderByData();
    
}
