package com.grammatico.negozio.DTO.inputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.inputDTO.TransazioneInputDTO;
import com.grammatico.negozio.model.entity.Transazione;

@Service
public class TransazioneInputDTOMapper implements Function<TransazioneInputDTO, Transazione>{

    @Override
    public Transazione apply(TransazioneInputDTO transazione) {
        return new Transazione(
            transazione.data(),
            transazione.tipo(),
            transazione.prezzoTotale(),
            transazione.info()
        );
    }
    
}
