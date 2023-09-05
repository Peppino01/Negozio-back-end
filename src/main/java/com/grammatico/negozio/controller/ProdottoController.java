package com.grammatico.negozio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grammatico.negozio.DTO.inputDTO.ProdottoInputDTO;
import com.grammatico.negozio.DTO.inputDTO.mapper.ProdottoInputDTOMapper;
import com.grammatico.negozio.DTO.outputDTO.ProdottoInventarioOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.ProdottoOutputDTO;
import com.grammatico.negozio.model.StatoProdotto;
import com.grammatico.negozio.model.entity.Inventario;
import com.grammatico.negozio.model.entity.Prodotto;
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

    // Costruttore che inizializza le dipendenze del controller
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

    // Restituisce la lista di tutti i prodotti gestiti dal negozio
    @GetMapping("/getAll")
    public ResponseEntity<List<ProdottoOutputDTO>> getAllProdotti() {
        List<ProdottoOutputDTO> prodotti = new ArrayList<>();

        // eseguo la ricerca nel db di tutti i prodotti
        try {
            prodotti = this.prodottoService.getAll();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(prodotti);
    }

    // Ricerca i prodotti che abbiano uno specifico stato
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

    // Inserisce un nuovo prodotto
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
                prodottoInputDTO.recensioni(),
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
    
}
