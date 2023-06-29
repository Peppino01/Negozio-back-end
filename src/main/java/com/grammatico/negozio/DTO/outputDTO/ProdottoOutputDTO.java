package com.grammatico.negozio.DTO.outputDTO;

import java.util.List;

import com.grammatico.negozio.model.entity.Inventario;
import com.grammatico.negozio.model.entity.Recenzione;
import com.grammatico.negozio.model.entity.Vendita;

public record ProdottoOutputDTO (
    Long id,
    String nome,
    int prezzo,
    String descrizione,
    List<Vendita> vendite,
    List<Recenzione> recenzioni,
    List<Inventario> inventario
) {
    
}
