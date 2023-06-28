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

import com.grammatico.negozio.DTO.inputDTO.DipendenteInputDTO;
import com.grammatico.negozio.DTO.inputDTO.mapper.DipendenteInputDTOMapper;
import com.grammatico.negozio.DTO.outputDTO.DipendenteOutputDTO;
import com.grammatico.negozio.model.entity.Dipendente;
import com.grammatico.negozio.service.DipendenteService;

@RestController
@RequestMapping("dipendenti")
public class DipendenteController {

    DipendenteService dipendenteService;
    DipendenteInputDTOMapper dipendenteInputDTOMapper;

    public DipendenteController(
        DipendenteService dipendenteService,
        DipendenteInputDTOMapper dipendenteInputDTOMapper
    ) {
        this.dipendenteService = dipendenteService;
        this.dipendenteInputDTOMapper = dipendenteInputDTOMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDipendente(@RequestBody DipendenteInputDTO dipendenteInputDTO) {
        // mappo dipendenteInputDTO in un oggetto di tipo Dipendente
        Dipendente dipendente = dipendenteInputDTOMapper.apply(dipendenteInputDTO);

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
            if(!dipendenteService.insert(dipendente).isValid()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante la creazione del dipendente");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore sconosciuto");
        }
        
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DipendenteOutputDTO>> getAllDipendenti() {
        List<DipendenteOutputDTO> dipendnti = new ArrayList<>();

        // eseguo la ricerca nel db di tutti i dipendenti
        try {
            dipendnti = this.dipendenteService.getAll();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(dipendnti);
    }
    
}
