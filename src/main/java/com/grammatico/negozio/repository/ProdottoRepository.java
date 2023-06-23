package com.grammatico.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
    
}
