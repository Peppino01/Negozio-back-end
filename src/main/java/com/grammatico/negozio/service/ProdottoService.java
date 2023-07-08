package com.grammatico.negozio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grammatico.negozio.DTO.outputDTO.ProdottoInventarioOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.ProdottoOutputDTO;
import com.grammatico.negozio.DTO.outputDTO.mapper.ProdottoOutputDTOMapper;
import com.grammatico.negozio.model.StatoProdotto;
import com.grammatico.negozio.model.entity.Prodotto;
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

    @Override
    public Long getIdFromNome(String nome) {
        Prodotto prodotto = prodottoRepository.findByNome(nome);
        if (prodotto != null) {
            return prodotto.getId();
        }
        return null;
    }

    @Override
    public Integer getPrezzoFromNome(String nome) {
        Prodotto prodotto = prodottoRepository.findByNome(nome);
        if (prodotto != null) {
            return prodotto.getPrezzo();
        }
        return null;
    }

    @Override
    public boolean saveProdotto(Prodotto prodotto) {
        if (prodottoRepository.save(prodotto) instanceof Prodotto) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkNomeExists(String nome) {
        if (nome != null) {
            return prodottoRepository.existsByNome(nome);
        } else {
            return false;
        }
    }

    public Integer getQuantitaFromStatoAndNomeProdotto(StatoProdotto stato, String nome) {
        if (stato == null) {
            return null;
        }
        if (nome.isEmpty()) {
            return null;
        }

        return prodottoRepository.countInventarioProdotto(nome, stato);
    }
    
}
