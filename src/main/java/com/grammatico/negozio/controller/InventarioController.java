package com.grammatico.negozio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grammatico.negozio.DTO.outputDTO.ProdottoInventarioOutputDTO;

@RestController
@RequestMapping("inventario")
public class InventarioController {

    @GetMapping
    public ResponseEntity<List<ProdottoInventarioOutputDTO>> getProdottiInventarioFromStato() {
        List<ProdottoInventarioOutputDTO> prodottiInventario = new ArrayList<>();

        return ResponseEntity.ok(prodottiInventario);
    }
    
}
