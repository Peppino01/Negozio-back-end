package com.grammatico.negozio.DTO.outputDTO.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.ProdottoOutputDTO;
import com.grammatico.negozio.model.entity.Prodotto;

@Service
public class ProdottoOutputDTOMapper implements Function<Prodotto, ProdottoOutputDTO>{

    @Override
    public ProdottoOutputDTO apply(Prodotto prodotto) {
        return new ProdottoOutputDTO(
            prodotto.getId(),
            prodotto.getNome(),
            prodotto.getPrezzo(),
            prodotto.getDescrizione(),
            prodotto.getVendite(),
            prodotto.getRecenzioni(),
            prodotto.getInventario()
        );
    }
    
}
