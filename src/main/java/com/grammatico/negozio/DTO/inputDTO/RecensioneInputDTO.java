package com.grammatico.negozio.DTO.inputDTO;

public record RecensioneInputDTO (
    String emailCliente,
    String nomeProdotto,
    int valutazione,
    String commento
) {
    
}
