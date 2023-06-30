package com.grammatico.negozio.DTO.inputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.inputDTO.InventarioInputDTO;
import com.grammatico.negozio.model.entity.Inventario;

@Service
public class InventarioInputDTOMapper implements Function<InventarioInputDTO, Inventario> {
    
    @Override
    public Inventario apply(InventarioInputDTO inventarioInputDTO) {
        return new Inventario(
            inventarioInputDTO.id(),
            inventarioInputDTO.quantita(),
            inventarioInputDTO.stato()
        );
    }

}
