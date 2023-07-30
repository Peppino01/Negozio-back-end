package com.grammatico.negozio.DTO.outputDTO;

import java.util.Date;

public record RecensioneOutputDTO (
    Long id,
    Date dataPubblicazione,
    int valutazione,
    String commento,
    String nome,
    String cognome
) {
    
}
