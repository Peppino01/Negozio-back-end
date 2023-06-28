package com.grammatico.negozio.DTO.inputDTO;

import java.sql.Date;

public record ProprietarioInputDTO (
    Long id,
    String nome,
    String cognome,
    String email,
    String password,
    String numTelefono,
    Date dataNascita
) {
    
}
