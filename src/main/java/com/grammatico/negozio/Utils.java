package com.grammatico.negozio;

public class Utils {
    
    public static boolean verificaFormatoEmail(String email) {
        // Definisco l'espressione regolare per validare l'email
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Restituisco true se l'email è valida, false altrimenti
        return email.matches(regex);
    }

}
