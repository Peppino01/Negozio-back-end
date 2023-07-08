package com.grammatico.negozio.DTO.outputDTO;

import java.util.Date;
import java.util.List;

public record TransazioneDetailOutputDTO (
    Long id,
    Date data,
    String tipo,
    Integer prezzoTotale,
    String info,
    List<VenditaProdottoOutputDTO> vendite,
    ClienteSimpleOutputDTO cliente
) {
    
}
