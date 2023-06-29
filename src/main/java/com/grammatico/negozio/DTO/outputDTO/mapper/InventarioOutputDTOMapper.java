package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import com.grammatico.negozio.DTO.outputDTO.InventarioOutputDTO;
import com.grammatico.negozio.model.entity.Inventario;

public class InventarioOutputDTOMapper implements Function<Inventario, InventarioOutputDTO> {

    @Override
    public InventarioOutputDTO apply(Inventario inventario) {
        return new InventarioOutputDTO(
            inventario.getId(),
            inventario.getQuantita(),
            inventario.getStato()
        );
    }
    
}
