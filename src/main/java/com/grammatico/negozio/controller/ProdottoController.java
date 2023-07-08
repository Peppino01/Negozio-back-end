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

import com.grammatico.negozio.DTO.inputDTO.ProdottoCarrelloInputDTO;
import com.grammatico.negozio.DTO.inputDTO.ProdottoInputDTO;
import com.grammatico.negozio.DTO.inputDTO.mapper.ProdottoInputDTOMapper;
import com.grammatico.negozio.DTO.outputDTO.ProdottoInventarioOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.ProdottoOutputDTO;
import com.grammatico.negozio.model.StatoProdotto;
import com.grammatico.negozio.model.entity.Inventario;
import com.grammatico.negozio.model.entity.Prodotto;
import com.grammatico.negozio.model.entity.Transazione;
import com.grammatico.negozio.model.entity.Vendita;
import com.grammatico.negozio.service.ClienteService;
import com.grammatico.negozio.service.InventarioService;
import com.grammatico.negozio.service.ProdottoService;
import com.grammatico.negozio.service.TransazioneService;

@RestController
@RequestMapping("prodotti")
public class ProdottoController {

    ProdottoService prodottoService;
    ClienteService clienteService;
    InventarioService inventarioService;
    TransazioneService transazioneService;
    ProdottoInputDTOMapper prodottoInputDTOMapper;

    public ProdottoController(
        ProdottoService prodottoService,
        ClienteService clienteService,
        InventarioService inventarioService,
        TransazioneService transazioneService,
        ProdottoInputDTOMapper prodottoInputDTOMapper
    ) {
        this.prodottoService = prodottoService;
        this.clienteService = clienteService;
        this.inventarioService = inventarioService;
        this.transazioneService = transazioneService;
        this.prodottoInputDTOMapper = prodottoInputDTOMapper;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ProdottoOutputDTO>> getAllDipendenti() {
        List<ProdottoOutputDTO> prodotti = new ArrayList<>();

        // eseguo la ricerca nel db di tutti i prodotti
        try {
            prodotti = this.prodottoService.getAll();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(prodotti);
    }

    @GetMapping("/inventario")
    public ResponseEntity<List<ProdottoInventarioOutputDTO>> getProdottiInventario(
        @RequestParam(required = false) StatoProdotto stato
    ) {
        List<ProdottoInventarioOutputDTO> prodottiInventario = new ArrayList<>();

        // eseguo la ricerca dei prodotti dell'inventario con lo stato ricevuto
        try {
            prodottiInventario = this.prodottoService.getProdottiInventarioFromStato(stato);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(prodottiInventario);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveProdotto(
        @RequestBody ProdottoInputDTO prodottoInputDTO
    ) {

        // controllo la validità dei campi nome e prezzo
        if (prodottoInputDTO.nome() == null  || prodottoInputDTO.nome().isBlank()) {
            return ResponseEntity.badRequest().body("Il nome è obbligatorio");
        }
        if (prodottoInputDTO.prezzo() < 0) {
            return ResponseEntity.badRequest().body("Il prezzo deve essere maggiore di zero");
        }

        // controllo che non sia già presente un prodotto con lo stesso nome
        try {
            if (prodottoService.checkNomeExists(prodottoInputDTO.nome())) {
            return ResponseEntity.badRequest().body("Esiste già un prodotto con lo stesso nome");
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body("Errore durante il controllo del nome");
        }
        
        if (prodottoInputDTO.inventario().isEmpty()) {
            List<Inventario> inventarioVuoto = new ArrayList<Inventario>();
            inventarioVuoto.add(new Inventario(0, StatoProdotto.DISPONIBILE));
            inventarioVuoto.add(new Inventario(0, StatoProdotto.NON_DISPONIBILE));
            inventarioVuoto.add(new Inventario(0, StatoProdotto.IN_PROMOZIONE));
            inventarioVuoto.add(new Inventario(0, StatoProdotto.VENDUTO));
            prodottoInputDTO = new ProdottoInputDTO(
                prodottoInputDTO.nome(),
                prodottoInputDTO.prezzo(),
                prodottoInputDTO.descrizione(),
                prodottoInputDTO.vendite(),
                prodottoInputDTO.recenzioni(),
                inventarioVuoto
            );
        }
        
        // controllo la validità dell'inventario
        if (!Inventario.validForOneProdotto(prodottoInputDTO.inventario())) {
            return ResponseEntity.badRequest().body("Inventario non valido");
        }

        // trasformo prodottoInputDTO in prodotto
        Prodotto prodotto = prodottoInputDTOMapper.apply(prodottoInputDTO);

        try {
            // salvo il prodotto
            if (prodottoService.saveProdotto(prodotto)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.internalServerError().body("Errore durante il salvataggio del prodotto");
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body("Errore sconosciuto durante il salvataggio del prodotto");
        }
    }

    @PatchMapping("/compra")
    public ResponseEntity<String> compraProdotti(
        @RequestParam Long idCliente,
        @RequestParam String info,
        @RequestBody List<ProdottoCarrelloInputDTO> carrello
    ) {

        // controllo che esista un cliente con l'id dato
        if (!clienteService.checkExistsById(idCliente)) {
            return ResponseEntity.badRequest().body("Non esiste un cliente con l'id inserito");
        }

        // per ogni prodotto nel carrello
        for (ProdottoCarrelloInputDTO prodottoCarrello : carrello) {
            // controllo che esistano dei prodotti con i nomi dati
            if (!prodottoService.checkNomeExists(prodottoCarrello.nome())) {
                return ResponseEntity.badRequest().body("Non esiste un prodotto con nome: " + prodottoCarrello.nome());
            }

            // controllo la validità del parametro quantia
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

    
}
