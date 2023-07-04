package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.ProdottoSimpleOutputDTO;
import com.grammatico.negozio.model.entity.Prodotto;

@Service
public class ProdottoSimpleOutputDTOMapper implements Function<Prodotto, ProdottoSimpleOutputDTO>{

    @Override
    public ProdottoSimpleOutputDTO apply(Prodotto prodotto) {
        return new ProdottoSimpleOutputDTO(
            prodotto.getNome(),
            prodotto.getPrezzo(),
            prodotto.getDescrizione()
        );
    }
    
}
