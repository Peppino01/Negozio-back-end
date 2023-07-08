package com.grammatico.negozio.DTO.outputDTO;

import java.util.Date;

public record RecenzioneOutputDTO (
    Long id,
    Date dataPubblicazione,
    int valutazione,
    String commento
) {
    
}
