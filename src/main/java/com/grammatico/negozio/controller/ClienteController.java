package com.grammatico.negozio.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grammatico.negozio.Utils;
import com.grammatico.negozio.DTO.inputDTO.ProdottoCarrelloInputDTO;
import com.grammatico.negozio.DTO.outputDTO.ClienteInfoOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.ProdottoCarrelloOutputDTO;
import com.grammatico.negozio.model.StatoProdotto;
import com.grammatico.negozio.model.entity.Cliente;
import com.grammatico.negozio.model.entity.ProdottoCarrello;
import com.grammatico.negozio.model.entity.Transazione;
import com.grammatico.negozio.model.entity.Vendita;
import com.grammatico.negozio.service.CarrelloService;
import com.grammatico.negozio.service.ClienteService;
import com.grammatico.negozio.service.InventarioService;
import com.grammatico.negozio.service.ProdottoService;
import com.grammatico.negozio.service.TransazioneService;

@RestController
@RequestMapping("clienti")
public class ClienteController {

    ClienteService clienteService;
    CarrelloService carrelloService;
    ProdottoService prodottoService;
    InventarioService inventarioService;
    TransazioneService transazioneService;

    public ClienteController(
        ClienteService clienteService,
        CarrelloService carrelloService,
        ProdottoService prodottoService,
        InventarioService inventarioService,
        TransazioneService transazioneService
    ) {
        this.clienteService = clienteService;
        this.carrelloService = carrelloService;
        this.prodottoService = prodottoService;
        this.inventarioService = inventarioService;
        this.transazioneService = transazioneService;
    }

    @GetMapping("getCarrello")
    public ResponseEntity<List<ProdottoCarrelloOutputDTO>> getCarrello(@RequestParam String email) {

        // controllo se l'email ha un formato valido
        if (!Utils.verificaFormatoEmail(email)) {
            System.out.println("Email non valida");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // controllo se il cliente è stato trovato
        if (!clienteService.checkExistsByEmail(email)) {
            System.out.println("Cliente non trovato");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        try {
            // ricavo l'id del cliente dalla email
            Cliente cliente = clienteService.getClienteFromEmail(email);
            Long idCliente = cliente.getId();

            // recupero tutti i prodotti che il cliente ha nel suo carrello
            List<ProdottoCarrelloOutputDTO> carrello = carrelloService.getCarrello(idCliente);

            return ResponseEntity.ok(carrello);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("aggiungiAlCarrello")
    public ResponseEntity<String> aggiungiAlCarrello(
        @RequestParam String email,
        @RequestBody ProdottoCarrelloInputDTO prodottoCarrelloInput
    ) {

        // controllo se l'email ha un formato valido
        if (!Utils.verificaFormatoEmail(email)) {
            System.out.println("Email non valida");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // controllo se il cliente è stato trovato
        if (!clienteService.checkExistsByEmail(email)) {
            System.out.println("Cliente non trovato");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // ricavo l'id del cliente dalla email
        Long idCliente;
        try {
            Cliente cliente = clienteService.getClienteFromEmail(email);
            idCliente = cliente.getId();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }

        // controllo se il cliente ha già il prodotto selezionato nel carrello
        
        // se il cliente ha già il prodotto selezionato nel carrello non devo aggiungere al carrello al prodotto ma modificarne la quantità

        // creo l'oggetto di tipo ProdottoCarrello
        ProdottoCarrello prodottoCarrello = new ProdottoCarrello(
            prodottoCarrelloInput.quantita(),
            idCliente,
            prodottoService.getIdFromNome(prodottoCarrelloInput.nome())
        );

        try {
            // aggiungo il prodotto al carello del cliente
            carrelloService.aggiungiAlCarrello(prodottoCarrello);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }

        return null;
    }

    @PatchMapping("/compra")
    public ResponseEntity<String> compraProdotti(
        @RequestParam String email,
        @RequestParam String info,
        @RequestBody List<ProdottoCarrelloInputDTO> carrello
    ) {
        // controllo se l'email ha un formato valido
        if (!Utils.verificaFormatoEmail(email)) {
            System.out.println("Email non valida");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // controllo se il cliente è stato trovato
        if (!clienteService.checkExistsByEmail(email)) {
            System.out.println("Cliente non trovato");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // ricavo l'id del cliente dalla email
        Long idCliente;
        try {
            Cliente cliente = clienteService.getClienteFromEmail(email);
            idCliente = cliente.getId();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }

        // per ogni prodotto nel carrello
        for (ProdottoCarrelloInputDTO prodottoCarrello : carrello) {
            // controllo che esistano dei prodotti con i nomi dati
            if (!prodottoService.checkNomeExists(prodottoCarrello.nome())) {
                return ResponseEntity.badRequest().body("Non esiste un prodotto con nome: " + prodottoCarrello.nome());
            }

            // controllo la validità del parametro quantita
            if (prodottoCarrello.quantita() <= 0) {
                return ResponseEntity.badRequest().body("La quantità deve essere positiva");
            }
            if (prodottoCarrello.quantita() > prodottoService.getQuantitaFromStatoAndNomeProdotto(StatoProdotto.DISPONIBILE, prodottoCarrello.nome())) {
                return ResponseEntity.badRequest().body("Non ci sono abbastanza prodotti (" + prodottoCarrello.nome() + ") disponibili");
            }
        }

        // per ogni prodotto nel carrello sposto la quantità di prodotti da disponibili a venduti
        try {
            for (ProdottoCarrelloInputDTO prodottoCarrello : carrello) {
                inventarioService.compraProdotto(prodottoService.getIdFromNome(prodottoCarrello.nome()), prodottoCarrello.quantita());
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body("Errore sconosciuto durante l'acquisto dei prodotti");
        }

        // svuoto il carrello del cliente
        try {
            this.carrelloService.cleanCarrelloFromIdCliente(idCliente);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body("Errore sconosciuto durante l'eliminazione dei prodotti dal carrello");
        }

        // creo la transazione associata ai prodotti acquistati dal cliente
        List<Vendita> vendite = new ArrayList<>();
        Transazione transazione;
        try {
            // creo una vendita per ogni prodotto
            for (ProdottoCarrelloInputDTO prodottoCarrello : carrello) {
                vendite.add(
                    new Vendita(
                        prodottoCarrello.quantita(),
                        prodottoService.getIdFromNome(prodottoCarrello.nome())
                    )
                );
            }

            // calcolo il prezzo totale della transazione
            Integer prezzoTotale = 0;
            for (ProdottoCarrelloInputDTO prodottoCarrello : carrello) {
                prezzoTotale += prodottoService.getPrezzoFromNome(prodottoCarrello.nome()) * prodottoCarrello.quantita();
            }

            // creo la transazione con le vendite create
            transazione = new Transazione(
                (Date) Calendar.getInstance().getTime(),
                "Acquisto prodotto",
                prezzoTotale,
                info,
                vendite,
                idCliente
            );
            
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body("Errore sconosciuto durante la creazione della transazione");
        }

        // salvo la nuova transazione
        try {
            transazioneService.insertTransazione(transazione);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body("Errore sconosciuto durante il salvataggio della transazione");
        }
        
        return ResponseEntity.ok("Prodotti comprati!");
    }

    @GetMapping("/info")
    public ResponseEntity<ClienteInfoOutputDTO> infoCliente(
        @RequestParam String email
    ) {
        // controllo se l'email ha un formato valido
        if (!Utils.verificaFormatoEmail(email)) {
            System.out.println("Email non valida");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // controllo se il cliente è stato trovato
        if (!clienteService.checkExistsByEmail(email)) {
            System.out.println("Cliente non trovato");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // ricavo il cliente dalla email
        Cliente cliente;
        try {
            cliente = clienteService.getClienteFromEmail(email);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }

        // creo l'oggetto di tipo ClienteInfoOutputDTO
        ClienteInfoOutputDTO clienteInfoOutputDTO = new ClienteInfoOutputDTO(
            cliente.getNome(),
            cliente.getCognome(),
            cliente.getCarrello().size()
        );

        return ResponseEntity.ok(clienteInfoOutputDTO);
    }
    
}
