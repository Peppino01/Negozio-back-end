package com.grammatico.negozio.DTO.inputDTO;

import java.sql.Date;
import java.util.List;

import com.grammatico.negozio.model.entity.Vendita;

public record TransazioneInputDTO (
    Long id,
    Date data,
    String tipo,
    int prezzoTotale,
    String info,
    List<Vendita> vendite
) {
    
}
