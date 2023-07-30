package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.ClienteOutputDTO;
import com.grammatico.negozio.model.entity.Cliente;

@Service
public class ClienteOutputDTOMapper implements Function<Cliente, ClienteOutputDTO>{

    @Override
    public ClienteOutputDTO apply(Cliente cliente) {
        return new ClienteOutputDTO(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCognome(),
            cliente.getEmail(),
            cliente.getPassword(),
            cliente.getNumTelefono(),
            cliente.getDataNascita(),
            cliente.getGenere(),
            cliente.getTransazioni(),
            cliente.getRecensioni()
        );
    }
    
}
