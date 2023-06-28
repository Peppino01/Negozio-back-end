package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.TransazioneOutputDTO;
import com.grammatico.negozio.model.entity.Transazione;

@Service
public class TransazioneOutputDTOMapper implements Function<Transazione, TransazioneOutputDTO>{

    @Override
    public TransazioneOutputDTO apply(Transazione transazione) {
        return new TransazioneOutputDTO(
            transazione.getId(),
            transazione.getData(),
            transazione.getIdCliente(),
            transazione.getTipo(),
            transazione.getPrezzoTotale(),
            transazione.getInfo()
        );
    }
    
}
