package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.RecenzioneOutputDTO;
import com.grammatico.negozio.model.entity.Recenzione;

@Service
public class RecenzioneOutputDTOMapper implements Function<Recenzione, RecenzioneOutputDTO>{

    @Override
    public RecenzioneOutputDTO apply(Recenzione recenzione) {
        return new RecenzioneOutputDTO(
            recenzione.getId(),
            recenzione.getDataPubblicazione(),
            recenzione.getValutazione(),
            recenzione.getCommento(),
            recenzione.getIdProdotto(),
            recenzione.getIdCliente()
        );
    }
    
}
