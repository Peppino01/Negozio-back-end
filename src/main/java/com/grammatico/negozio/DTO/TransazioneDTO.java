package com.grammatico.negozio.DTO;

import java.sql.Date;

public record TransazioneDTO (
    Long id,
    Date data,
    Long idCliente,
    String tipo,
    int prezzoTotale,
    String info
) {
    
}
