package com.grammatico.negozio.DTO.inputDTO;

import java.util.Date;

public record DipendenteInputDTO (
    String nome,
    String cognome,
    String email,
    String password,
    String numTelefono,
    Date dataNascita,
    int stipendio
) {
    
}
