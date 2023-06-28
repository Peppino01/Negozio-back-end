package com.grammatico.negozio.DTO.inputDTO;

import java.sql.Date;

public record RecenzioneInputDTO (
    Long id,
    Date dataPubblicazione,
    int valutazione,
    String commento,
    Long idProdotto,
    Long idCliente
) {
    
}
