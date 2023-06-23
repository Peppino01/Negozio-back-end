package com.grammatico.negozio.DTO;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.Dipendente;

@Service
public class DipendenteDTOMapper implements Function<Dipendente, DipendenteDTO>{

    @Override
    public DipendenteDTO apply(Dipendente dipendente) {
        return new DipendenteDTO(
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
