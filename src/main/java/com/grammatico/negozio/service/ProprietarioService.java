package com.grammatico.negozio.service;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.entity.Proprietario;
import com.grammatico.negozio.repository.ProprietarioRepository;
import com.grammatico.negozio.service.interfaces.IProprietarioService;

@Service
public class ProprietarioService implements IProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    public ProprietarioService(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    @Override
    public boolean checkCredentials(String email, String password) {
        Proprietario proprietario = proprietarioRepository.findByEmail(email);
        if (proprietario == null) {
            System.out.println("Proprietario non trovato");
            return false; // Proprietario non trovato
        }

        // Confronta la password fornita con quella salvata nel proprietario
        return proprietario.getPassword().equals(password);
    }

    @Override
    public boolean checkExistsByEmail(String email) {
        Proprietario proprietario = proprietarioRepository.findByEmail(email);

        return proprietario != null;
    }

    @Override
    public Proprietario getProprietarioFromEmail(String email) {
        return proprietarioRepository.findByEmail(email);
    }
    
}
