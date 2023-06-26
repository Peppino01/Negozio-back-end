package com.grammatico.negozio.DTO;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.model.entity.Vendita;

@Service
public class VenditaDTOMapper implements Function<Vendita, VenditaDTO>{

    @Override
    public VenditaDTO apply(Vendita vendita) {
        return new VenditaDTO(
            vendita.getId(),
            vendita.getidTransazione(),
            vendita.getidProdotto(),
            vendita.getquantita(),
            vendita.getprezzoUnitario()
        );
    }
    
}
