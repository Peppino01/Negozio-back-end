package com.grammatico.negozio.DTO;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.Cliente;

@Service
public class ClienteDTOMapper implements Function<Cliente, ClienteDTO>{

    @Override
    public ClienteDTO apply(Cliente cliente) {
        return new ClienteDTO(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCognome(),
            cliente.getEmail(),
            cliente.getPassword(),
            cliente.getNumTelefono(),
            cliente.getDataNascita()
        );
    }
    
}