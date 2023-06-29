package com.grammatico.negozio.DTO.inputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.inputDTO.RecenzioneInputDTO;
import com.grammatico.negozio.model.entity.Recenzione;

@Service
public class RecenzioneInputDTOMapper implements Function<RecenzioneInputDTO, Recenzione>{

    @Override
    public Recenzione apply(RecenzioneInputDTO recenzione) {
        return new Recenzione(
            recenzione.dataPubblicazione(),
            recenzione.valutazione(),
            recenzione.commento()
        );
    }
    
}
