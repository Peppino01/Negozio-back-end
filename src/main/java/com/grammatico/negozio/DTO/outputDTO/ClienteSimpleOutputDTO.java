package com.grammatico.negozio.DTO.outputDTO;

import java.sql.Date;

import com.grammatico.negozio.model.Genere;

public record ClienteSimpleOutputDTO (
    String nome,
    String cognome,
    String email,
    String password,
    String numTelefono,
    Date dataNascita,
    Genere genere
) {
    
}
