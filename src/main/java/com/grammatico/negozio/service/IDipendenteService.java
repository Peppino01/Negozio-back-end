package com.grammatico.negozio.service;

import java.util.List;

import com.grammatico.negozio.DTO.DipendenteDTO;
import com.grammatico.negozio.model.entity.Dipendente;

public interface IDipendenteService {

    public Dipendente insertDipendente(Dipendente nuovoDipendente);

    public List<DipendenteDTO> getAllDipendenti();

    public boolean checkExistsByEmail(String email);
    
}
