package com.grammatico.negozio.DTO.inputDTO;

import java.sql.Date;

public record TransazioneInputDTO (
    Long id,
    Date data,
    Long idCliente,
    String tipo,
    int prezzoTotale,
    String info
) {
    
}
