package com.grammatico.negozio.service;

import java.util.List;

import com.grammatico.negozio.DTO.DipendenteDTO;
import com.grammatico.negozio.model.Dipendente;

public interface IDipendenteService {

    public void insertDipendente(Dipendente nuovoDipendente);

    public List<DipendenteDTO> getAllDipendenti();
    
}
