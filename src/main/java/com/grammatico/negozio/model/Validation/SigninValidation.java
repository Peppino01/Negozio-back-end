package com.grammatico.negozio.model.Validation;

import java.util.Date;

import com.grammatico.negozio.Utils;
import com.grammatico.negozio.model.Genere;

public class SigninValidation implements Validation {

    String nome;
    String cognome;
    String email;
    String password;
    String numTelefono;
    Date dataNascita;
    Genere genere;

    public SigninValidation(String nome, String cognome, String email, String password, String numTelefono, Date dataNascita, Genere genere) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.numTelefono = numTelefono;
        this.dataNascita = dataNascita;
        this.genere = genere;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean isValid() {
        return
            isNomeValid(this.nome) &&
            isCognomeValid(this.cognome) &&
            isEmailValid(this.email) &&
            isPasswordValid(this.password) &&
            isNumTelefonolValid(this.numTelefono) &&
            isDataNascitaValid(this.dataNascita) &&
            isGenereValid(this.genere);
    }


    // Il nome deve essere presente
    private boolean isNomeValid(String nome) {
        return nome.length() >= 0;
    }

    // Il cognome deve essere presente
    private boolean isCognomeValid(String cognome) {
        return cognome.length() >= 0;
    }

    // Controllo il formato della mail
    private boolean isEmailValid(String email) {
        return Utils.verificaFormatoEmail(email);
    }

    // La password ha una lunghezza minima
    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    // Controllo il formato del numero di telefono
    private boolean isNumTelefonolValid(String numTelefono) {
        String numTelefonoRegex = "^[0-9]{10,}$";
        return numTelefono.matches(numTelefonoRegex);
    }

    // Controllo se la data di nascita è precedente alla data odierna
    private boolean isDataNascitaValid(Date dataNascita) {
        return dataNascita.before(new Date());
    }

    // Controllo se il genere fa parte dell'enum Genere
    private boolean isGenereValid(Genere password) {
        switch (genere) {
            case MASCHIO:
            case FEMMINA:
            case ALTRO:
                // Il genere è valido
                return true;
            default:
                // Il genere non è valido
                return false;
        }
    }

}
