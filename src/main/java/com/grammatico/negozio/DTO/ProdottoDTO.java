package com.grammatico.negozio.DTO;

public record ProdottoDTO (
    Long id,
    String nome,
    int prezzo,
    String descrizione,
    int quantita,
    String stato
) {
    
}
