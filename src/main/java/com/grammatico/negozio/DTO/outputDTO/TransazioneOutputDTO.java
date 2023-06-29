package com.grammatico.negozio.DTO.outputDTO;

import java.sql.Date;
import java.util.List;

import com.grammatico.negozio.model.entity.Vendita;

public record TransazioneOutputDTO (
    Long id,
    Date data,
    String tipo,
    int prezzoTotale,
    String info,
    List<Vendita> vendite
) {
    
}
