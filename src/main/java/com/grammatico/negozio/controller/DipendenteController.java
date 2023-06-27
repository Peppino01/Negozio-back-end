package com.grammatico.negozio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            System.out.println("Errore sconosciuto\n" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore sconosciuto");
        }
        
        return ResponseEntity.ok("");
    }
    
}
