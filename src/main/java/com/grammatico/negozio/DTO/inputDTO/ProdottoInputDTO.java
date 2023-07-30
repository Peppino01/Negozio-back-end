package com.grammatico.negozio.DTO.inputDTO;

import java.util.List;

import com.grammatico.negozio.model.entity.Inventario;
import com.grammatico.negozio.model.entity.Recensione;
import com.grammatico.negozio.model.entity.Vendita;

public record ProdottoInputDTO (
    String nome,
    int prezzo,
    String descrizione,
    List<Vendita> vendite,
    List<Recensione> recensioni,
    List<Inventario> inventario
) {
    
}
