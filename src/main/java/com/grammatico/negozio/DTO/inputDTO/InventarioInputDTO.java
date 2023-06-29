package com.grammatico.negozio.DTO.inputDTO;

import com.grammatico.negozio.model.StatoProdotto;

public record InventarioInputDTO(
    Long id,
    int quantita,
    StatoProdotto stato
) {
    
}
