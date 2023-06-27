package com.grammatico.negozio.service;

import com.grammatico.negozio.model.entity.Cliente;

public interface IClienteService {

    public boolean checkClienteCredentials(String email, String password);

    public boolean checkExistsByEmail(String email);

    public Cliente insertCliente(Cliente cliente);

    public Cliente getClienteFromEmail(String email);
    
}
