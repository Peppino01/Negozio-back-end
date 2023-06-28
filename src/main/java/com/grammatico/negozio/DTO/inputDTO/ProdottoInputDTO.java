package com.grammatico.negozio.DTO.inputDTO;

import com.grammatico.negozio.model.StatoProdotto;

public record ProdottoInputDTO (
    Long id,
    String nome,
    int prezzo,
    String descrizione,
    int quantita,
    StatoProdotto stato
) {
    
}
