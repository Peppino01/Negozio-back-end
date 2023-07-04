package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.ClienteSimpleOutputDTO;
import com.grammatico.negozio.model.entity.Cliente;

@Service
public class ClienteSimpleOutputDTOMapper implements Function<Cliente, ClienteSimpleOutputDTO>{

    @Override
    public ClienteSimpleOutputDTO apply(Cliente cliente) {
        return new ClienteSimpleOutputDTO(
            cliente.getNome(),
            cliente.getCognome(),
            cliente.getEmail(),
            cliente.getPassword(),
            cliente.getNumTelefono(),
            cliente.getDataNascita(),
            cliente.getGenere()
        );
    }
    
}
