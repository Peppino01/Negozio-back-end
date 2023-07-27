package com.grammatico.negozio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.ProdottoCarrelloOutputDTO;
import com.grammatico.negozio.model.entity.ProdottoCarrello;
import com.grammatico.negozio.repository.CarrelloRepository;
import com.grammatico.negozio.service.interfaces.ICarrelloService;

@Service
public class CarrelloService implements ICarrelloService {

    private final CarrelloRepository carrelloRepository;

    public CarrelloService(CarrelloRepository carrelloRepository) {
        this.carrelloRepository = carrelloRepository;
    }

    @Override
    public List<ProdottoCarrelloOutputDTO> getCarrello(Long idCliente) {
        return carrelloRepository.getCarrelloFromIdCliente(idCliente);
    }

    @Override
    public ProdottoCarrello aggiungiAlCarrello(ProdottoCarrello prodottoCarrello) {
        return this.carrelloRepository.save(prodottoCarrello);
    }

    @Override
    public Integer getFromIdProdottoAndIdCliente(Long idProdotto, Long idCliente) {
        return this.carrelloRepository.getProdottoCarrelloFromIdProdottoAndIdCliente(idCliente, idProdotto);
    }

    @Override
    public void cleanCarrelloFromIdCliente(Long idCliente) {
        this.carrelloRepository.deleteAllByIdCliente(idCliente);
    }
    
}
