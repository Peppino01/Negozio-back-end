package com.grammatico.negozio.DTO.inputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.inputDTO.ProdottoInputDTO;
import com.grammatico.negozio.model.entity.Prodotto;

@Service
public class ProdottoInputDTOMapper implements Function<ProdottoInputDTO, Prodotto>{

    @Override
    public Prodotto apply(ProdottoInputDTO prodotto) {
        return new Prodotto(
            prodotto.nome(),
            prodotto.prezzo(),
            prodotto.descrizione(),
            prodotto.vendite(),
            prodotto.recenzioni(),
            prodotto.inventario()
        );
    }
    
}
