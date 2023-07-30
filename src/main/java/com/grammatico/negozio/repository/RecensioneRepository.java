package com.grammatico.negozio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.entity.Recensione;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {

    List<Recensione> findByidProdotto(Long idProdotto);
    
}
