package com.grammatico.negozio.model.Validation;

import com.grammatico.negozio.Utils;

public class LoginValidation implements Validation {

    String email;
    String password;

    public LoginValidation(String email, String password) {
        this.email = email;
        this.password = password;
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
        return isEmailValid(this.email) && isPasswordValid(this.password);
    }

    private boolean isEmailValid(String email) {
        return Utils.verificaFormatoEmail(email);
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

}
