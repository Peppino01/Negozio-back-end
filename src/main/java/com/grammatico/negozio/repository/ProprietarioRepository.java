package com.grammatico.negozio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grammatico.negozio.model.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
    
}
