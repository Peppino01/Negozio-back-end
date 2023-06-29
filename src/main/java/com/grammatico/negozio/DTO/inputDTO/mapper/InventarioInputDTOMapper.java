package com.grammatico.negozio.DTO.inputDTO.mapper;

import java.util.function.Function;

import com.grammatico.negozio.DTO.inputDTO.InventarioInputDTO;
import com.grammatico.negozio.model.entity.Inventario;

public class InventarioInputDTOMapper implements Function<InventarioInputDTO, Inventario> {
    
    @Override
    public Inventario apply(InventarioInputDTO inventarioInputDTO) {
        return new Inventario(
            inventarioInputDTO.quantita(),
            inventarioInputDTO.stato()
        );
    }

}
