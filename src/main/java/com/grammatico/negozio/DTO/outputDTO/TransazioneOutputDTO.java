package com.grammatico.negozio.DTO.outputDTO;

import java.sql.Date;

public record TransazioneOutputDTO (
    Long id,
    Date data,
    Long idCliente,
    String tipo,
    int prezzoTotale,
    String info
) {
    
}
