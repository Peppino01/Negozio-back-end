package com.grammatico.negozio.DTO;

public record VenditaDTO (
    Long id,
    Long idTransazione,
    Long idProdotto,
    int quantita,
    int prezzoUnitario
) {
    
}
