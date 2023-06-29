package com.grammatico.negozio.service;

import com.grammatico.negozio.repository.InventarioRepository;

public class InventarioService {

    InventarioRepository inventarioRepository;

    public InventarioService(
        InventarioRepository inventarioRepository
    ) {
        this.inventarioRepository = inventarioRepository;
    }
    
}
