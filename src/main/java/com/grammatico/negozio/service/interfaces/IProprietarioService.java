package com.grammatico.negozio.service.interfaces;

import com.grammatico.negozio.model.entity.Proprietario;

public interface IProprietarioService {

    public boolean checkCredentials(String email, String password);

    public boolean checkExistsByEmail(String email);
    
    public Proprietario getProprietarioFromEmail(String email);
    
}
