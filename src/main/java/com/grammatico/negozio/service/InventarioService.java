package com.grammatico.negozio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.StatoProdotto;
import com.grammatico.negozio.model.entity.Inventario;
import com.grammatico.negozio.repository.InventarioRepository;

@Service
public class InventarioService {

    InventarioRepository inventarioRepository;

    public InventarioService(
        InventarioRepository inventarioRepository
    ) {
        this.inventarioRepository = inventarioRepository;
    }

    public boolean updateSingoloInventario(Inventario inventario) {
        if (inventarioRepository.save(inventario) instanceof Inventario) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existsById(Long id) {
        return this.inventarioRepository.existsById(id);
    }

    public boolean compraProdotto(Long idProdotto, int quantita) {
        // prendo gli inventari disponibile e venduto del prodotto
        Inventario inventarioProdottoDisponibile = inventarioRepository.findByIdProdottoAndStato(idProdotto, StatoProdotto.DISPONIBILE);
        Inventario inventarioProdottoVenduto = inventarioRepository.findByIdProdottoAndStato(idProdotto, StatoProdotto.VENDUTO);

        // sposto 'quantita' prodotti da disponibile a venduto
        inventarioProdottoDisponibile.setQuantita(inventarioProdottoDisponibile.getQuantita() - quantita);
        inventarioProdottoVenduto.setQuantita(inventarioProdottoVenduto.getQuantita() + quantita);

        // salvo gli inventari con i nuovi valori
        inventarioRepository.save(inventarioProdottoDisponibile);
        inventarioRepository.save(inventarioProdottoVenduto);
        
        return true;
    }
    
}
