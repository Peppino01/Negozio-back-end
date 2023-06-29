package com.grammatico.negozio.DTO.inputDTO;

import java.sql.Date;
import java.util.List;

import com.grammatico.negozio.model.Genere;
import com.grammatico.negozio.model.entity.Recenzione;
import com.grammatico.negozio.model.entity.Transazione;

public record ClienteInputDTO (
    Long id,
    String nome,
    String cognome,
    String email,
    String password,
    String numTelefono,
    Date dataNascita,
    Genere genere,
    List<Transazione> transazioni,
    List<Recenzione> recenzioni
) {
    
}
