package com.grammatico.negozio.service.interfaces;

import java.util.List;

import com.grammatico.negozio.DTO.outputDTO.TransazioneDetailOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.TransazioneSummaryOutputDTO;
import com.grammatico.negozio.model.entity.Transazione;

public interface ITransazioneService {

    List<TransazioneSummaryOutputDTO> getSummary();

    TransazioneDetailOutputDTO getDetailFromId(Long id);

    Transazione insertTransazione(Transazione transazione);
    
}
