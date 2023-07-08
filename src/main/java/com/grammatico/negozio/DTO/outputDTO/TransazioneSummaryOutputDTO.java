package com.grammatico.negozio.DTO.outputDTO;

import java.util.Date;

public record TransazioneSummaryOutputDTO (
    Long id,
    Date data,
    String tipo,
    Integer prezzoTotale
) {
    
}
