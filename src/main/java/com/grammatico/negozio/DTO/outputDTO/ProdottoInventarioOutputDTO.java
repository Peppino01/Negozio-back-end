package com.grammatico.negozio.DTO.outputDTO;

import com.grammatico.negozio.model.StatoProdotto;

public record ProdottoInventarioOutputDTO (
    String nome,
    StatoProdotto stato,
    int quantita,
    int prezzo,
    String descrizione
) {
    
}
