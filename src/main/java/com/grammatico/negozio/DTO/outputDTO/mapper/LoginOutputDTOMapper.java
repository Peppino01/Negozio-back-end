package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.LoginOutputDTO;
import com.grammatico.negozio.model.Ruolo;

@Service
public class LoginOutputDTOMapper implements Function<Ruolo, LoginOutputDTO> {

    @Override
    public LoginOutputDTO apply(Ruolo ruolo) {
        return new LoginOutputDTO(
            ruolo
        );
    }
    
}
