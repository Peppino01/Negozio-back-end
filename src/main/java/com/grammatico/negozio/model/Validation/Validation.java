package com.grammatico.negozio.model.Validation;

/**
 * Interfaccia di validazione, utilizzata per verificare la correttezza del login e del signin di un'utente
 * Implementa un solo metodo, il quale controllerà la validità dei campi della richiesta
 * Il valore di ritorno del metodo sarà true nel caso in cui tutti i campi della richiesta rispettino le condizioni necessarie, false altrimenti
 * 
 * I controlli che vengono effettuati dalle classi che implementano questa interfaccia non dipendono dai dati del database, ma sono basati su dati statici
 * definiti nel codice sorgente. Ad esempio, stiamo verificando la lunghezza della password o la presenza del simbolo '@' nell'email direttamente nel codice.
 * Questo serve ad avere ad avere un filtro sulle azioni di login e signin, evitando a monte di effettuare richieste al db dove sappiamo a priori
 * che i dati inseriti dall'utente non sono validi
 */
public interface Validation {

    public String getEmail();
    public String getPassword();

    public boolean isValid();
    
}
