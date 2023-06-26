package com.grammatico.negozio.service;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.entity.Cliente;
import com.grammatico.negozio.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public boolean checkClienteCredentials(String email, String password) {
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            System.out.println("Cliente non trovato");
            return false; // Cliente non trovato
        }

        // Confronta la password fornita con quella salvata nel cliente
        return cliente.getPassword().equals(password);
    }

    public boolean checkExistsByEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);

        return cliente != null;
    }

    public Cliente insertCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
}
