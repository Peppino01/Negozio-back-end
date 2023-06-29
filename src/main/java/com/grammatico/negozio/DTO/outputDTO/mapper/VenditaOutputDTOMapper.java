package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.VenditaOutputDTO;
import com.grammatico.negozio.model.entity.Vendita;

@Service
public class VenditaOutputDTOMapper implements Function<Vendita, VenditaOutputDTO>{

    @Override
    public VenditaOutputDTO apply(Vendita vendita) {
        return new VenditaOutputDTO(
            vendita.getId(),
            vendita.getQuantita()
        );
    }
    
}
