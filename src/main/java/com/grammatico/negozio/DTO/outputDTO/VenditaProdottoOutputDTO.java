package com.grammatico.negozio.DTO.outputDTO;

public record VenditaProdottoOutputDTO (
    Long id,
    int quantita,
    String nomeProdotto,
    int prezzoProdotto
) {
    
}
