package com.grammatico.negozio.DTO.inputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.inputDTO.ClienteInputDTO;
import com.grammatico.negozio.model.entity.Cliente;

@Service
public class ClienteInputDTOMapper implements Function<ClienteInputDTO, Cliente>{

    @Override
    public Cliente apply(ClienteInputDTO clienteDTO) {
        return new Cliente(
            clienteDTO.nome(),
            clienteDTO.cognome(),
            clienteDTO.email(),
            clienteDTO.password(),
            clienteDTO.numTelefono(),
            clienteDTO.dataNascita(),
            clienteDTO.genere()
        );
    }
    
}
