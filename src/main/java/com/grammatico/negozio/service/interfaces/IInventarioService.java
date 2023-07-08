package com.grammatico.negozio.service.interfaces;

import com.grammatico.negozio.model.entity.Inventario;

public interface IInventarioService {

    public boolean updateSingoloInventario(Inventario inventario);

    public boolean compraProdotto(Long idProdotto, int quantita);
    
}
