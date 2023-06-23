package com.grammatico.negozio.DTO;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.Prodotto;

@Service
public class ProdottoDTOMapper implements Function<Prodotto, ProdottoDTO>{

    @Override
    public ProdottoDTO apply(Prodotto prodotto) {
        return new ProdottoDTO(
            prodotto.getId(),
            prodotto.getNome(),
            prodotto.getPrezzo(),
            prodotto.getDescrizione(),
            prodotto.getQuantita(),
            prodotto.getStato()
        );
    }
    
}
