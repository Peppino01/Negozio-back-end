package com.grammatico.negozio.DTO.outputDTO;

import java.util.Date;
import java.util.List;

import com.grammatico.negozio.model.Genere;
import com.grammatico.negozio.model.entity.Recensione;
import com.grammatico.negozio.model.entity.Transazione;

public record ClienteOutputDTO (
    Long id,
    String nome,
    String cognome,
    String email,
    String password,
    String numTelefono,
    Date dataNascita,
    Genere genere,
    List<Transazione> transazioni,
    List<Recensione> recensioni
) {
    
}
