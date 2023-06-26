package com.grammatico.negozio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.DipendenteDTO;
import com.grammatico.negozio.DTO.DipendenteDTOMapper;
import com.grammatico.negozio.model.entity.Dipendente;
import com.grammatico.negozio.repository.DipendenteRepository;

@Service
public class DipendenteService implements IDipendenteService{

    private final DipendenteRepository dipendenteRepository;
    private final DipendenteDTOMapper dipendenteDTOMapper;

    public DipendenteService(
        DipendenteRepository dipendenteRepository,
        DipendenteDTOMapper dipendenteDTOMapper
    ) {
        this.dipendenteRepository = dipendenteRepository;
        this.dipendenteDTOMapper = dipendenteDTOMapper;
    }

    @Override
    public void insertDipendente(Dipendente nuovoDipendente) {
        dipendenteRepository.save(nuovoDipendente);
    }

    @Override
    public List<DipendenteDTO> getAllDipendenti() {
        return dipendenteRepository.findAll().stream().map(dipendenteDTOMapper).collect(Collectors.toList());
    }
    
}
