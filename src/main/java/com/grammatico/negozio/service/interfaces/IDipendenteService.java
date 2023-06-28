package com.grammatico.negozio.service.interfaces;

import java.util.List;

import com.grammatico.negozio.DTO.outputDTO.DipendenteOutputDTO;
import com.grammatico.negozio.model.entity.Dipendente;

public interface IDipendenteService {

    public boolean checkCredentials(String email, String password);

    public Dipendente insert(Dipendente nuovoDipendente);

    public List<DipendenteOutputDTO> getAll();

    public boolean checkExistsByEmail(String email);
    
}
