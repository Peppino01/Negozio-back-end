package com.grammatico.negozio.service.interfaces;

import java.util.List;

import com.grammatico.negozio.DTO.outputDTO.ProdottoOutputDTO;

public interface IProdottoService {

    public List<ProdottoOutputDTO> getAll();
    
}
