package com.grammatico.negozio.DTO;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.entity.Proprietario;

@Service
public class ProprietarioDTOMapper implements Function<Proprietario, ProprietarioDTO>{

    @Override
    public ProprietarioDTO apply(Proprietario proprietario) {
        return new ProprietarioDTO(
            proprietario.getId(),
            proprietario.getNome(),
            proprietario.getCognome(),
            proprietario.getEmail(),
            proprietario.getPassword(),
            proprietario.getnumTelefono(),
            proprietario.getdataNascita()
        );
    }
    
}
