package com.grammatico.negozio.DTO.inputDTO;

import java.util.Date;
import java.util.List;

import com.grammatico.negozio.model.entity.Dipendente;

public record ProprietarioInputDTO (
    Long id,
    String nome,
    String cognome,
    String email,
    String password,
    String numTelefono,
    Date dataNascita,
    List<Dipendente> dipendenti
) {
    
}
