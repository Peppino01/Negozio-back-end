package com.grammatico.negozio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grammatico.negozio.DTO.ClienteDTO;
import com.grammatico.negozio.DTO.ClienteDTOMapper;
import com.grammatico.negozio.DTO.LoginDTO;
import com.grammatico.negozio.DTO.LoginDTOMapper;
import com.grammatico.negozio.model.Login;
import com.grammatico.negozio.model.entity.Cliente;
import com.grammatico.negozio.service.IClienteService;

@RestController
public class AuthController {

    private final LoginDTOMapper loginDTOMapper;
    private final ClienteDTOMapper clienteDTOMapper;
    private final IClienteService clienteService;

    public AuthController(
        LoginDTOMapper loginDTOMapper,
        ClienteDTOMapper clienteDTOMapper,
        IClienteService clienteService
        ) {
        this.loginDTOMapper = loginDTOMapper;
        this.clienteDTOMapper = clienteDTOMapper;
        this.clienteService = clienteService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginRequest) {
        Login login = loginDTOMapper.apply(loginRequest);
        Cliente cliente;
        ClienteDTO clienteDTO;

        if (!login.isValid()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email o password non valide");
        }

        if (!clienteService.checkClienteCredentials(login.getEmail(), login.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email o password errate");
        }

        try {
            cliente = clienteService.getClienteFromEmail(login.getEmail());
            if(cliente == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante la ricerca dell'utente");
            }
            clienteDTO = clienteDTOMapper.apply(cliente);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore sconosciuto");
        }

        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signup(@RequestBody ClienteDTO signinRequest) {
        Cliente cliente = clienteDTOMapper.apply(signinRequest);

        if (!cliente.isValid()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("I dati inseriti per la registrazione non sono validi");
        }

        if (clienteService.checkExistsByEmail(cliente.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Questa mail è già registrata");
        }

        try {
            if(!clienteService.insertCliente(cliente).isValid()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante la creazione dell'utente");
            }
        } catch (Exception e) {
            System.out.println("Errore sconosciuto\n" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore sconosciuto");
        }
        
        return ResponseEntity.ok("");
    }

}
