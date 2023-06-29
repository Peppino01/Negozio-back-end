package com.grammatico.negozio.DTO.outputDTO;

import java.sql.Date;

public record RecenzioneOutputDTO (
    Long id,
    Date dataPubblicazione,
    int valutazione,
    String commento
) {
    
}
