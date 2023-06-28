package com.grammatico.negozio.DTO.inputDTO;

public record VenditaInputDTO (
    Long id,
    Long idTransazione,
    Long idProdotto,
    int quantita,
    int prezzoUnitario
) {
    
}
