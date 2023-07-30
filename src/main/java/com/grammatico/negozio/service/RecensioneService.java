package com.grammatico.negozio.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.entity.Recensione;
import com.grammatico.negozio.repository.RecensioneRepository;
import com.grammatico.negozio.service.interfaces.IRecensioneService;

@Service
public class RecensioneService implements IRecensioneService {

    RecensioneRepository recensioneRepository;

    public RecensioneService(
        RecensioneRepository recensioneRepository
    ) {
        this.recensioneRepository = recensioneRepository;
    }

    @Override
    public List<Recensione> findByIdProdotto(Long idProdotto) {
        return recensioneRepository.findByidProdotto(idProdotto);
    }

    @Override
    public void insertRecensione(Date dataPubblicazione, int valutazione, String commento, Long idProdotto, Long idCliente) {
        // creo l'oggetto di tipo Recensione
        Recensione recensione = new Recensione(dataPubblicazione, valutazione, commento, idProdotto, idCliente);

        // salvo la nuova transazione
        recensioneRepository.save(recensione);
    }
    
}
