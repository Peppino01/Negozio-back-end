package com.grammatico.negozio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grammatico.negozio.DTO.inputDTO.InventarioInputDTO;
import com.grammatico.negozio.DTO.inputDTO.mapper.InventarioInputDTOMapper;
import com.grammatico.negozio.model.StatoProdotto;
import com.grammatico.negozio.model.entity.Inventario;
import com.grammatico.negozio.service.InventarioService;

@RestController
@RequestMapping("inventario")
public class InventarioController {

    InventarioService inventarioService;
    InventarioInputDTOMapper inventarioInputDTOMapper;

    public InventarioController(
        InventarioService inventarioService,
        InventarioInputDTOMapper inventarioInputDTOMapper
    ) {
        this.inventarioService = inventarioService;
        this.inventarioInputDTOMapper = inventarioInputDTOMapper;
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateInventarioProdotto(
        @RequestBody() List<InventarioInputDTO> inventarioInputDTO
    ) {
        // controllo se gli inventari inviati sono 4
        if (inventarioInputDTO.size() != 4) {
            return ResponseEntity.internalServerError().body("E' possibile cambiare solo 4 inventariProdotto alla volta");
        }
        
        // controllo che tutti gli stati e gli id siano diversi
        List<StatoProdotto> statiControllati = new ArrayList<>();
        List<Long> idControllati = new ArrayList<>();
        for (InventarioInputDTO invInDTO : inventarioInputDTO) {
            if (statiControllati.contains(invInDTO.stato())) {
                return ResponseEntity.internalServerError().body("Non è possibile cambiare più di un tipo di stato alla volta");
            } else if (idControllati.contains(invInDTO.id())) {
                return ResponseEntity.internalServerError().body("Non è possibile due inventari con lo stesso id");
            } else {
                statiControllati.add(invInDTO.stato());
                idControllati.add(invInDTO.id());
            }
        }

        // ricavo l'inventario da inventarioInputDTO
        List<Inventario> inventario = inventarioInputDTO.stream().map(inventarioInputDTOMapper).collect(Collectors.toList());

        // controllo che tutti gli inventari esistano già
        for (Inventario inv : inventario) {
            if (!inventarioService.existsById(inv.getId())) {
                return ResponseEntity.internalServerError().body("Non è stato trovato nessun inventario con id: " + inv.getId());
            }
        }

        // sovrascrivo tutti gli inventari con le nuove quantità
        for (Inventario inv : inventario) {
            if (!inventarioService.updateSingoloInventario(inv)) {
                return ResponseEntity.internalServerError().body("Erroe durante il salvataggio dell'inventario");
            } else {
                System.out.print(inv.getId());
            }
        }

        return ResponseEntity.ok().build();

    }
    
}
