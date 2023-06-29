package com.grammatico.negozio.DTO.inputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.inputDTO.VenditaInputDTO;
import com.grammatico.negozio.model.entity.Vendita;

@Service
public class VenditaInputDTOMapper implements Function<VenditaInputDTO, Vendita>{

    @Override
    public Vendita apply(VenditaInputDTO vendita) {
        return new Vendita(
            vendita.quantita()
        );
    }
    
}
