package com.grammatico.negozio.DTO.outputDTO;

import java.sql.Date;

public record TransazioneSummaryOutputDTO (
    Long id,
    Date data,
    String tipo,
    Integer prezzoTotale
) {
    
}
