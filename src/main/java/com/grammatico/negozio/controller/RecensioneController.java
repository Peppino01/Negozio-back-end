package com.grammatico.negozio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grammatico.negozio.DTO.inputDTO.RecensioneInputDTO;
import com.grammatico.negozio.DTO.outputDTO.RecensioneOutputDTO;
import com.grammatico.negozio.model.entity.Cliente;
import com.grammatico.negozio.model.entity.Recensione;
import com.grammatico.negozio.service.ClienteService;
import com.grammatico.negozio.service.ProdottoService;
import com.grammatico.negozio.service.RecensioneService;

@RestController
@RequestMapping("recensioni")
public class RecensioneController {

    RecensioneService recensioneService;
    ProdottoService prodottoService;
    ClienteService clienteService;

    // Costruttore che inizializza le dipendenze del controller
    public RecensioneController(
    RecensioneService recensioneService,
    ProdottoService prodottoService,
    ClienteService clienteService
    ) {
        this.recensioneService = recensioneService;
        this.prodottoService = prodottoService;
        this.clienteService = clienteService;
    }

    // Ritorna tutte le recensioni di uno specifico prodotto
    @GetMapping("getAllFromNomeProdotto")
    public ResponseEntity<List<RecensioneOutputDTO>> getAllFromNomeProdotto(
        @RequestParam() String nomeProdotto
    ) {
        //  controllo se esiste un prodotto con il nome dato
        try {
            if (!prodottoService.checkNomeExists(nomeProdotto)) {
                System.out.println("Prodotto non trovato");
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }

        // recupero l'id del prodotto
        Long idProdotto;
        try {
            idProdotto = prodottoService.getIdFromNome(nomeProdotto);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }

        // recupero tutti e le recensioni relative a quel prodotto
        List<Recensione> recensioni;
        try {
            recensioni = recensioneService.findByIdProdotto(idProdotto);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }

        // trasformo le recensioni in una lista di RecensioneOutputDTO
        List<RecensioneOutputDTO> recensioniOutput = new ArrayList<>();
        for (Recensione r : recensioni) {
            // ricavo il nome e cognome del cliente relativo alla recensione
            Cliente cliente = clienteService.getClienteFromId(r.getIdCliente());
            String nome = cliente.getNome();
            String cognome = cliente.getCognome();

            // aggiungo alla lista recensioniOutput l'oggetto con il nome e cognome trovati
            recensioniOutput.add(
                new RecensioneOutputDTO(
                    r.getId(),
                    r.getDataPubblicazione(),
                    r.getValutazione(),
                    r.getCommento(),
                    nome,
                    cognome
                )
            );
        }

        return ResponseEntity.ok(recensioniOutput);
    }

    // Inserisce una nuova recensione
    @PostMapping("insert")
    public ResponseEntity<String> insertRecensione(
        @RequestBody RecensioneInputDTO recensioneInput
    ) {
        // controllo la validità di tutti i campi
        if (recensioneInput.valutazione() < 1 || recensioneInput.valutazione() > 5) {
            System.out.println("valutazione non valida (deve essere compresa tra 1 e 5)");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("valutazione non valida (deve essere compresa tra 1 e 5)");
        }
        if (recensioneInput.commento() != null) {
            if (recensioneInput.commento().length() > 255) {
                System.out.println("Commento non valido (massimo 255 caratteri)");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Commento non valido (massimo 255 caratteri)");
            }
        }
        try {
            if (!clienteService.checkExistsByEmail(recensioneInput.emailCliente())) {
                System.out.println("Cliente non trovato");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente non trovato");
            }
            if (!prodottoService.checkNomeExists(recensioneInput.nomeProdotto())) {
                System.out.println("Prodotto non trovato");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Prodotto non trovato");
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
        
        // ricavo l'id del cliente e del prodotto
        Long idCliente, idProdotto;
        try {
            idCliente = clienteService.getClienteFromEmail(recensioneInput.emailCliente()).getId();
            idProdotto = prodottoService.getIdFromNome(recensioneInput.nomeProdotto());
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }

        // aggiungo alla tabella recensioni la nuova recensione
        try {
            recensioneService.insertRecensione(new Date(), recensioneInput.valutazione(), recensioneInput.commento(), idProdotto, idCliente);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().build();
    }
    
}
