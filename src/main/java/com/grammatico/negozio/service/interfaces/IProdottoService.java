package com.grammatico.negozio.service.interfaces;

import java.util.List;

import com.grammatico.negozio.DTO.outputDTO.ProdottoInventarioOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.ProdottoOutputDTO;
import com.grammatico.negozio.model.StatoProdotto;
import com.grammatico.negozio.model.entity.Prodotto;

public interface IProdottoService {

    public Long getIdFromNome(String nome);

    public Integer getPrezzoFromNome(String nome);

    public List<ProdottoOutputDTO> getAll();

    public List<ProdottoInventarioOutputDTO> getProdottiInventarioFromStato(StatoProdotto statoProdotto);

    public boolean saveProdotto(Prodotto prodotto);

    public boolean checkNomeExists(String nome);

    public Integer getQuantitaFromStatoAndNomeProdotto(StatoProdotto stato, String nome);
    
}
