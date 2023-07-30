package com.grammatico.negozio.service.interfaces;

import java.util.Date;
import java.util.List;

import com.grammatico.negozio.model.entity.Recensione;

public interface IRecensioneService {

    public List<Recensione> findByIdProdotto(Long idProdotto);

    public void insertRecensione(Date dataPubblicazione, int valutazione, String commento, Long idProdotto, Long idCliente);
    
}
