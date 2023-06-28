package com.grammatico.negozio.DTO.inputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.inputDTO.LoginInputDTO;
import com.grammatico.negozio.model.Login;

@Service
public class LoginInputDTOMapper implements Function<LoginInputDTO, Login> {

    @Override
    public Login apply(LoginInputDTO loginDTO) {
        return new Login(
            loginDTO.email(),
            loginDTO.password()
        );
    }
    
}
