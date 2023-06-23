package com.grammatico.negozio.DTO;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.Transazione;

@Service
public class TransazioneDTOMapper implements Function<Transazione, TransazioneDTO>{

    @Override
    public TransazioneDTO apply(Transazione transazione) {
        return new TransazioneDTO(
            transazione.getId(),
            transazione.getData(),
            transazione.getIdCliente(),
            transazione.getTipo(),
            transazione.getPrezzoTotale(),
            transazione.getInfo()
        );
    }
    
}
