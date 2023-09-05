package com.grammatico.negozio.DTO.inputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.inputDTO.LoginInputDTO;
import com.grammatico.negozio.model.Validation.LoginValidation;

@Service
public class LoginInputDTOMapper implements Function<LoginInputDTO, LoginValidation> {

    @Override
    public LoginValidation apply(LoginInputDTO loginDTO) {
        return new LoginValidation(
            loginDTO.email(),
            loginDTO.password()
        );
    }
    
}
