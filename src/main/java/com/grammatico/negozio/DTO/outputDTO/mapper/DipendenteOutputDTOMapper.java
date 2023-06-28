package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.DipendenteOutputDTO;
import com.grammatico.negozio.model.entity.Dipendente;

@Service
public class DipendenteOutputDTOMapper implements Function<Dipendente, DipendenteOutputDTO>{

    @Override
    public DipendenteOutputDTO apply(Dipendente dipendente) {
        return new DipendenteOutputDTO(
            dipendente.getId(),
            dipendente.getNome(),
            dipendente.getCognome(),
            dipendente.getEmail(),
            dipendente.getPassword(),
            dipendente.getNumTelefono(),
            dipendente.getDataNascita(),
            dipendente.getStipendio()
        );
    }
    
}
