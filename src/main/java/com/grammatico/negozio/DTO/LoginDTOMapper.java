package com.grammatico.negozio.DTO;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.Login;

@Service
public class LoginDTOMapper implements Function<Login, LoginDTO> {

    @Override
    public LoginDTO apply(Login login) { // trasforma un Login in un LoginDTO
        return new LoginDTO(
            login.getEmail(),
            login.getPassword()
        );
    }

    public Login apply(LoginDTO login) { // trasforma un LoginDTO in un Login
        return new Login(
            login.email(),
            login.password()
        );
    }
    
}
