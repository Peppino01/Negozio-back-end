package com.grammatico.negozio.service.interfaces;

import java.util.List;

import com.grammatico.negozio.DTO.outputDTO.ProdottoInventarioOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.ProdottoOutputDTO;
import com.grammatico.negozio.model.StatoProdotto;

public interface IProdottoService {

    public List<ProdottoOutputDTO> getAll();

    public List<ProdottoInventarioOutputDTO> getProdottiInventarioFromStato(StatoProdotto statoProdotto);
    
}
