package com.grammatico.negozio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.ProdottoInventarioOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.ProdottoOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.mapper.ProdottoOutputDTOMapper;
import com.grammatico.negozio.model.StatoProdotto;
import com.grammatico.negozio.repository.ProdottoRepository;
import com.grammatico.negozio.service.interfaces.IProdottoService;

@Service
public class ProdottoService implements IProdottoService {

    ProdottoRepository prodottoRepository;
    ProdottoOutputDTOMapper prodottoOutputDTOMapper;

    public ProdottoService(
        ProdottoRepository prodottoRepository,
        ProdottoOutputDTOMapper prodottoOutputDTOMapper
    ) {
        this.prodottoRepository =  prodottoRepository;
        this.prodottoOutputDTOMapper = prodottoOutputDTOMapper;
    }

    @Override
    public List<ProdottoOutputDTO> getAll() {
        return prodottoRepository.findAll().stream().map(prodottoOutputDTOMapper).collect(Collectors.toList());
    }

    @Override
    public List<ProdottoInventarioOutputDTO> getProdottiInventarioFromStato(StatoProdotto statoProdotto) {
        if (statoProdotto  == null) {
            return prodottoRepository.getAllProdottiInventario();
        } else {
            return prodottoRepository.getProdottiInventarioFromStato(statoProdotto);
        }
    }
    
}
