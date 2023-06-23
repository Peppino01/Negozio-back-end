package com.grammatico.negozio.DTO;

import java.sql.Date;

public record ProprietarioDTO (
    Long id,
    String nome,
    String cognome,
    String email,
    String password,
    String numTelefono,
    Date dataNascita
) {
    
}
