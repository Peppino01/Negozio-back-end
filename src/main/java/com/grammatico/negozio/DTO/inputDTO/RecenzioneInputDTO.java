package com.grammatico.negozio.DTO.inputDTO;

import java.util.Date;

public record RecenzioneInputDTO (
    Long id,
    Date dataPubblicazione,
    int valutazione,
    String commento
) {
    
}
