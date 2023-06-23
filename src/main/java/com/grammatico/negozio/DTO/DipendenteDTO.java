package com.grammatico.negozio.DTO;

import java.sql.Date;

public record DipendenteDTO (
    Long id,
    String nome,
    String cognome,
    String email,
    String password,
    String numTelefono,
    Date dataNascita,
    int stipendio
) {
    
}
