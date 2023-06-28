package com.grammatico.negozio.DTO.inputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.inputDTO.ProprietarioInputDTO;
import com.grammatico.negozio.model.entity.Proprietario;

@Service
public class ProprietarioInputDTOMapper implements Function<ProprietarioInputDTO, Proprietario>{

    @Override
    public Proprietario apply(ProprietarioInputDTO proprietario) {
        return new Proprietario(
            proprietario.nome(),
            proprietario.cognome(),
            proprietario.email(),
            proprietario.password(),
            proprietario.numTelefono(),
            proprietario.dataNascita()
        );
    }
    
}
