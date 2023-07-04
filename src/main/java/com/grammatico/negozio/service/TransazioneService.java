package com.grammatico.negozio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.TransazioneSummaryOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.mapper.TransazioneSummaryOutputDTOMapper;
import com.grammatico.negozio.repository.TransazioneRepository;
import com.grammatico.negozio.service.interfaces.ITransazioneService;

@Service
public class TransazioneService implements ITransazioneService {

    TransazioneRepository transazioneRepository;
    TransazioneSummaryOutputDTOMapper transazioneSummaryOutputDTOMapper;

    public TransazioneService(
        TransazioneRepository transazioneRepository,
        TransazioneSummaryOutputDTOMapper transazioneSummaryOutputDTOMapper
    ) {
        this.transazioneRepository = transazioneRepository;
        this.transazioneSummaryOutputDTOMapper = transazioneSummaryOutputDTOMapper;
    }

    public List<TransazioneSummaryOutputDTO> getSummary() {
        return this.transazioneRepository.findAllByOrderByData().stream().map(this.transazioneSummaryOutputDTOMapper).collect(Collectors.toList());
    }
    
}
