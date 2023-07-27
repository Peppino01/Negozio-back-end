package com.grammatico.negozio.service.interfaces;

import java.util.List;

import com.grammatico.negozio.DTO.outputDTO.ProdottoCarrelloOutputDTO;
import com.grammatico.negozio.model.entity.ProdottoCarrello;

public interface ICarrelloService {

    public List<ProdottoCarrelloOutputDTO> getCarrello(Long idCliente);

    public ProdottoCarrello aggiungiAlCarrello(ProdottoCarrello prodottoCarrello);

    public Integer getFromIdProdottoAndIdCliente(Long idProdotto, Long idCliente);

    public void cleanCarrelloFromIdCliente(Long idCliente);
    
}
