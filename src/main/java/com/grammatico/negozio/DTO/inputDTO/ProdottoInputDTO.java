package com.grammatico.negozio.DTO.inputDTO;

import java.util.List;

import com.grammatico.negozio.model.entity.Inventario;
import com.grammatico.negozio.model.entity.Recenzione;
import com.grammatico.negozio.model.entity.Vendita;

public record ProdottoInputDTO (
    Long id,
    String nome,
    int prezzo,
    String descrizione,
    List<Vendita> vendite,
    List<Recenzione> recenzioni,
    List<Inventario> inventario
) {
    
}
