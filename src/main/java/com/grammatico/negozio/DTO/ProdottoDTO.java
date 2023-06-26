package com.grammatico.negozio.DTO;

import com.grammatico.negozio.model.StatoProdotto;

public record ProdottoDTO (
    Long id,
    String nome,
    int prezzo,
    String descrizione,
    int quantita,
    StatoProdotto stato
) {
    
}
