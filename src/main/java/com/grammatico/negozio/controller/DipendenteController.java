package com.grammatico.negozio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grammatico.negozio.DTO.DipendenteDTO;
import com.grammatico.negozio.DTO.DipendenteDTOMapper;
import com.grammatico.negozio.model.entity.Dipendente;
import com.grammatico.negozio.service.DipendenteService;

@RestController
@RequestMapping("admin")
public class DipendenteController {

    DipendenteService dipendenteService;
    DipendenteDTOMapper dipendenteDTOMapper;

    public DipendenteController(
        DipendenteService dipendenteService,
        DipendenteDTOMapper dipendenteDTOMapper
    ) {
        this.dipendenteService = dipendenteService;
        this.dipendenteDTOMapper = dipendenteDTOMapper;
    }

    @PostMapping("/createDipendente")
    public ResponseEntity<String> createDipendente(@RequestBody DipendenteDTO dipendenteDTO) {
        Dipendente dipendente = dipendenteDTOMapper.apply(dipendenteDTO);

        // verifico la validità dei dati del dipendente
        if (!dipendente.isValid()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("I dati inseriti non sono validi");
        }

        // verifico che non esista già un dipendente con la stessa email
        if (dipendenteService.checkExistsByEmail(dipendente.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esiste già un dipendente con la stessa mail");
        }

        // effettuo l'inserimento del nuovo dipendente
        try {
            if(!dipendenteService.insertDipendente(dipendente).isValid()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante la creazione del dipendente");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore sconosciuto");
        }
        
        return ResponseEntity.ok("");
    }

    @GetMapping("/allDipendenti")
    public ResponseEntity<List<DipendenteDTO>> getAllDipendenti() {
        List<DipendenteDTO> dipendnti = new ArrayList<>();

        // eseguo la ricerca nel db di tutti i dipendenti
        try {
            dipendnti = this.dipendenteService.getAllDipendenti();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        System.out.println(dipendnti);
        return ResponseEntity.ok(dipendnti);
    }
    
}
