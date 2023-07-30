package com.grammatico.negozio.service.interfaces;

import com.grammatico.negozio.model.entity.Cliente;

public interface IClienteService {

    public boolean checkCredentials(String email, String password);

    public boolean checkExistsByEmail(String email);

    public boolean checkExistsById(Long id);

    public Cliente insertCliente(Cliente cliente);

    public Cliente getClienteFromEmail(String email);

    public Cliente getClienteFromId(Long id);
    
}
