package com.grammatico.negozio.DTO.outputDTO;

import java.util.List;

import com.grammatico.negozio.model.entity.Inventario;
import com.grammatico.negozio.model.entity.Recensione;
import com.grammatico.negozio.model.entity.Vendita;

public record ProdottoOutputDTO (
    Long id,
    String nome,
    int prezzo,
    String descrizione,
    List<Vendita> vendite,
    List<Recensione> recensioni,
    List<Inventario> inventario
) {
    
}
