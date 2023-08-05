package com.grammatico.negozio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grammatico.negozio.Utils;
import com.grammatico.negozio.DTO.outputDTO.ProprietarioInfoOutputDTO;
import com.grammatico.negozio.model.entity.Proprietario;
import com.grammatico.negozio.service.ProprietarioService;

@RestController
@RequestMapping("proprietario")
public class ProprietarioController {

    ProprietarioService proprietarioService;

    public ProprietarioController(
        ProprietarioService proprietarioService
    ) {
        this.proprietarioService = proprietarioService;
    }

    @GetMapping("info")
    public ResponseEntity<ProprietarioInfoOutputDTO> getInfo(
        @RequestParam String email
    ) {
        // controllo se l'email ha un formato valido
        if (!Utils.verificaFormatoEmail(email)) {
            System.out.println("Email non valida");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // controllo se il proprietario è stato trovato
        if (!proprietarioService.checkExistsByEmail(email)) {
            System.out.println("Proprietario non trovato");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // ricavo il proprietario dalla email
        Proprietario proprietario;
        try {
            proprietario = proprietarioService.getProprietarioFromEmail(email);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }

        System.out.println(proprietario.getDipendenti());

        // creo l'oggetto di tipo ProprietarioInfoOutputDTO
        ProprietarioInfoOutputDTO proprietarioInfoOutputDTO = new ProprietarioInfoOutputDTO(
            proprietario.getNome(),
            proprietario.getCognome(),
            proprietario.getDipendenti().size()
        );

        return ResponseEntity.ok(proprietarioInfoOutputDTO);
    }
    
}
