package com.grammatico.negozio.model.Validation;

import java.util.Date;

import com.grammatico.negozio.model.Genere;

public class ValidationFactory {
    
    public Validation createLoginValidation(String email, String password) {
        return new LoginValidation(email, password);
    }

    public Validation createSigninValidation(String nome, String cognome, String email, String password, String numTelefono, Date dataNascita, Genere genere) {
        return new SigninValidation(nome, cognome, email, password, numTelefono, dataNascita, genere);
    }
    
}
