package com.grammatico.negozio.DTO.outputDTO;

import com.grammatico.negozio.model.StatoProdotto;

public record ProdottoOutputDTO (
    Long id,
    String nome,
    int prezzo,
    String descrizione,
    int quantita,
    StatoProdotto stato
) {
    
}
