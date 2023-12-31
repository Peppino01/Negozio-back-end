package com.grammatico.negozio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grammatico.negozio.DTO.inputDTO.TransazioneInputDTO;
import com.grammatico.negozio.DTO.inputDTO.mapper.TransazioneInputDTOMapper;
import com.grammatico.negozio.DTO.outputDTO.TransazioneDetailOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.TransazioneSummaryOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.mapper.TransazioneOutputDTOMapper;
import com.grammatico.negozio.model.entity.Transazione;
import com.grammatico.negozio.service.interfaces.ITransazioneService;

@RestController
@RequestMapping("transazioni")
public class TransazioneController {

    ITransazioneService transazioneService;
    TransazioneInputDTOMapper transazioneInputDTOMapper;
    TransazioneOutputDTOMapper transazioneOutputDTOMapper;

    // Costruttore che inizializza le dipendenze del controller
    public TransazioneController(
        ITransazioneService transazioneService,
        TransazioneInputDTOMapper transazioneInputDTOMapper,
        TransazioneOutputDTOMapper transazioneOutputDTOMapper
    ) {
        this.transazioneService = transazioneService;
        this.transazioneInputDTOMapper = transazioneInputDTOMapper;
        this.transazioneOutputDTOMapper = transazioneOutputDTOMapper;
    }

    // Delle informazioni non specifiche di tutte le transazioni
    @GetMapping("summary")
    public ResponseEntity<List<TransazioneSummaryOutputDTO>> getSummary() {
        List<TransazioneSummaryOutputDTO> summary = new ArrayList<>();
        try {
            summary = transazioneService.getSummary();
        } catch (Exception e) {
            System.out.println(e);
        }

        return ResponseEntity.ok().body(summary);
    }

    // Tutte le informazioni riguardanti una transazione particolare
    @GetMapping("info")
    public ResponseEntity<TransazioneDetailOutputDTO> getTransazioneDetail(
        @RequestParam() Long id
    ) {
        TransazioneDetailOutputDTO transazioneDetail = this.transazioneService.getDetailFromId(id);

        if (transazioneDetail == null) {
            return ResponseEntity.internalServerError().build();
        } else {
            return ResponseEntity.ok().body(transazioneDetail);
        }
    }

    // Inserimento di una nuova transazione
    @PostMapping("insert")
    public ResponseEntity<String> insertTransazione(
        @RequestBody TransazioneInputDTO transazioneInput
    ) {
        Transazione transazione = transazioneInputDTOMapper.apply(transazioneInput);

        try {
            this.transazioneService.insertTransazione(transazione);
        } catch (Exception e) {
            System.out.println("Errore: - " + e);
            ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok("Transazione inserita con successo");

    }
    
}
