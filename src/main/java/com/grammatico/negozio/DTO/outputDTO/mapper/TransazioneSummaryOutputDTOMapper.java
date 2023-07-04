package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.TransazioneSummaryOutputDTO;
import com.grammatico.negozio.model.entity.Transazione;

@Service
public class TransazioneSummaryOutputDTOMapper implements Function<Transazione, TransazioneSummaryOutputDTO> {

    @Override
    public TransazioneSummaryOutputDTO apply(Transazione transazione) {
        return new TransazioneSummaryOutputDTO(
            transazione.getId(),
            transazione.getData(),
            transazione.getTipo(),
            transazione.getPrezzoTotale(),
            transazione.getInfo()
        );
    }
    
}
