package com.grammatico.negozio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.StatoProdotto;
import com.grammatico.negozio.model.entity.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    List<Inventario> findByIdProdotto(Long idProdotto);

    Inventario findByIdProdottoAndStato(Long idProdotto, StatoProdotto stato);
    
}
