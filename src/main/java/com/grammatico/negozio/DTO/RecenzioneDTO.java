package com.grammatico.negozio.DTO;

import java.sql.Date;

public record RecenzioneDTO (
    Long id,
    Date dataPubblicazione,
    int valutazione,
    String commento,
    Long idProdotto,
    Long idCliente
) {
    
}
