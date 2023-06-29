package com.grammatico.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.entity.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    
}
