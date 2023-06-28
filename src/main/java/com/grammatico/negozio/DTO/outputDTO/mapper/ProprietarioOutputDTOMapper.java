package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.ProprietarioOutputDTO;
import com.grammatico.negozio.model.entity.Proprietario;

@Service
public class ProprietarioOutputDTOMapper implements Function<Proprietario, ProprietarioOutputDTO>{

    @Override
    public ProprietarioOutputDTO apply(Proprietario proprietario) {
        return new ProprietarioOutputDTO(
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
