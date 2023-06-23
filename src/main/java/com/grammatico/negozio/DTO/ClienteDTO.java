package com.grammatico.negozio.DTO;

import java.sql.Date;

public record ClienteDTO (
    Long id,
    String nome,
    String cognome,
    String email,
    String password,
    String numTelefono,
    Date dataNascita
) {
    
}
