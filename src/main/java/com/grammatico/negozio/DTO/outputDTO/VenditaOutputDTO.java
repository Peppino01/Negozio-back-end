package com.grammatico.negozio.DTO.outputDTO;

public record VenditaOutputDTO (
    Long id,
    Long idTransazione,
    Long idProdotto,
    int quantita,
    int prezzoUnitario
) {
    
}
