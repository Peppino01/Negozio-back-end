package com.grammatico.negozio.DTO;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.Recenzione;

@Service
public class RecenzioneDTOMapper implements Function<Recenzione, RecenzioneDTO>{

    @Override
    public RecenzioneDTO apply(Recenzione recenzione) {
        return new RecenzioneDTO(
            recenzione.getId(),
            recenzione.getDataPubblicazione(),
            recenzione.getValutazione(),
            recenzione.getCommento(),
            recenzione.getIdProdotto(),
            recenzione.getIdCliente()
        );
    }
    
}
