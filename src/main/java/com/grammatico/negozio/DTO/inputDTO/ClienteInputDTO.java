package com.grammatico.negozio.DTO.inputDTO;

import java.sql.Date;

import com.grammatico.negozio.model.Genere;

public record ClienteInputDTO (
    String nome,
    String cognome,
    String email,
    String password,
    String numTelefono,
    Date dataNascita,
    Genere genere
) {
    
}
