package com.grammatico.negozio.service.interfaces;

import java.util.List;

import com.grammatico.negozio.DTO.outputDTO.DipendenteOutputDTO;
import com.grammatico.negozio.model.entity.Dipendente;

public interface IDipendenteService {

    public boolean checkCredentials(String email, String password);

    public Dipendente insertDipendente(Dipendente nuovoDipendente);

    public List<DipendenteOutputDTO> getAllDipendenti();

    public boolean checkExistsByEmail(String email);
    
}
