package com.grammatico.negozio.DTO.inputDTO;

import java.util.Date;
import java.util.List;

import com.grammatico.negozio.model.entity.Vendita;

public record TransazioneInputDTO (
    Date data,
    String tipo,
    Integer prezzoTotale,
    String info,
    List<Vendita> vendite
) {
    
}
