package com.grammatico.negozio.service;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.entity.Cliente;
import com.grammatico.negozio.repository.ClienteRepository;
import com.grammatico.negozio.service.interfaces.IClienteService;

@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public boolean checkCredentials(String email, String password) {
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            System.out.println("Cliente non trovato");
            return false; // Cliente non trovato
        }

        // Confronta la password fornita con quella salvata nel cliente
        return cliente.getPassword().equals(password);
    }

    @Override
    public boolean checkExistsByEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);

        return cliente != null;
    }

    @Override
    public Cliente insertCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente getClienteFromEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
    
}
