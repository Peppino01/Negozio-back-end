package com.grammatico.negozio.service;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.entity.Inventario;
import com.grammatico.negozio.repository.InventarioRepository;

@Service
public class InventarioService {

    InventarioRepository inventarioRepository;

    public InventarioService(
        InventarioRepository inventarioRepository
    ) {
        this.inventarioRepository = inventarioRepository;
    }

    public boolean updateSingoloInventario(Inventario inventario) {
        if (inventarioRepository.save(inventario) instanceof Inventario) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existsById(Long id) {
        return this.inventarioRepository.existsById(id);
    }
    
}
