package com.grammatico.negozio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.DipendenteOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.mapper.DipendenteOutputDTOMapper;
import com.grammatico.negozio.model.entity.Dipendente;
import com.grammatico.negozio.repository.DipendenteRepository;
import com.grammatico.negozio.service.interfaces.IDipendenteService;

@Service
public class DipendenteService implements IDipendenteService {

    private final DipendenteRepository dipendenteRepository;
    private final DipendenteOutputDTOMapper dipendenteOutputDTOMapper;

    public DipendenteService(
        DipendenteRepository dipendenteRepository,
        DipendenteOutputDTOMapper dipendenteOutputDTOMapper
    ) {
        this.dipendenteRepository = dipendenteRepository;
        this.dipendenteOutputDTOMapper = dipendenteOutputDTOMapper;
    }

    @Override
    public boolean checkCredentials(String email, String password) {
        Dipendente dipendente = dipendenteRepository.findByEmail(email);
        if (dipendente == null) {
            System.out.println("Dipendente non trovato");
            return false; // Dipendente non trovato
        }

        // Confronta la password fornita con quella salvata nel dipendente
        return dipendente.getPassword().equals(password);
    }

    @Override
    public Dipendente insertDipendente(Dipendente nuovoDipendente) {
        return dipendenteRepository.save(nuovoDipendente);
    }

    @Override
    public List<DipendenteOutputDTO> getAllDipendenti() {
        return dipendenteRepository.findAll().stream().map(dipendenteOutputDTOMapper).collect(Collectors.toList());
    }

    @Override
    public boolean checkExistsByEmail(String email) {
        Dipendente dipendente = dipendenteRepository.findByEmail(email);

        return dipendente != null;
    }
    
}
