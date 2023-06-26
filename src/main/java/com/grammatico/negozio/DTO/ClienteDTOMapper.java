package com.grammatico.negozio.DTO;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.entity.Cliente;

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
            cliente.getDataNascita(),
            cliente.getGenere()
        );
    }

    public Cliente apply(ClienteDTO clienteDTO) {
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
