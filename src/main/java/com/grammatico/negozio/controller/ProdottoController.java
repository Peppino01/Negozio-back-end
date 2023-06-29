package com.grammatico.negozio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grammatico.negozio.DTO.outputDTO.ProdottoInventarioOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.ProdottoOutputDTO;
import com.grammatico.negozio.model.StatoProdotto;
import com.grammatico.negozio.service.ProdottoService;

@RestController
@RequestMapping("prodotti")
public class ProdottoController {

    ProdottoService prodottoService;

    public ProdottoController(
        ProdottoService prodottoService
    ) {
        this.prodottoService = prodottoService;
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
    
}
