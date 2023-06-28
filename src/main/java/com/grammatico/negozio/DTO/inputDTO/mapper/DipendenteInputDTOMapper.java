package com.grammatico.negozio.DTO.inputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.inputDTO.DipendenteInputDTO;
import com.grammatico.negozio.model.entity.Dipendente;

@Service
public class DipendenteInputDTOMapper implements Function<DipendenteInputDTO, Dipendente>{

    @Override
    public Dipendente apply(DipendenteInputDTO dipendenteDTO) {
        return new Dipendente(
            dipendenteDTO.nome(),
            dipendenteDTO.cognome(),
            dipendenteDTO.email(),
            dipendenteDTO.password(),
            dipendenteDTO.numTelefono(),
            dipendenteDTO.dataNascita(),
            dipendenteDTO.stipendio()
        );
    }
    
}
