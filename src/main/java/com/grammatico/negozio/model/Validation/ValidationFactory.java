package com.grammatico.negozio.model.Validation;

import java.util.Date;

import com.grammatico.negozio.model.Genere;

/**
 * La funzione di questa classe è quella di agevolare la creazione di due diverse tipologie di validazione:
 * la prima, denominata LoginValidation, è finalizzata alla verifica delle credenziali per l'accesso, mentre la seconda,
 * denominata SigninValidation, si concentra sulla convalida dei dati per il processo di registrazione. Questa struttura
 * organizzativa permette una gestione più efficace e modulare delle diverse esigenze di validazione all'interno
 * dell'applicazione.
 */
public class ValidationFactory {
    
    public Validation createLoginValidation(String email, String password) {
        return new LoginValidation(email, password);
    }

    public Validation createSigninValidation(String nome, String cognome, String email, String password, String numTelefono, Date dataNascita, Genere genere) {
        return new SigninValidation(nome, cognome, email, password, numTelefono, dataNascita, genere);
    }
    
}
