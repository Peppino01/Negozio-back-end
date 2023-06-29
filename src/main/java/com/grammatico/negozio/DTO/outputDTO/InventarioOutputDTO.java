package com.grammatico.negozio.DTO.outputDTO;

import com.grammatico.negozio.model.StatoProdotto;

public record InventarioOutputDTO(
    Long id,
    int quantita,
    StatoProdotto stato
) {
    
}
