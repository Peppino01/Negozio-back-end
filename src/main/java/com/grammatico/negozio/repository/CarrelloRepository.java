package com.grammatico.negozio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.grammatico.negozio.DTO.outputDTO.ProdottoCarrelloOutputDTO;
import com.grammatico.negozio.model.entity.ProdottoCarrello;

public interface CarrelloRepository extends JpaRepository<ProdottoCarrello, Long> {

    @Query(
        "SELECT new com.grammatico.negozio.DTO.outputDTO.ProdottoCarrelloOutputDTO(p.nome, p.prezzo, p.descrizione, c.quantita) " +
        "FROM ProdottoCarrello c " +
        "JOIN Prodotto p ON c.idProdotto = p.id " +
        "WHERE c.idCliente = :idCliente"
    )
    List<ProdottoCarrelloOutputDTO> getCarrelloFromIdCliente(Long idCliente);

    @Query(
        "SELECT pc.quantita " +
        "FROM ProdottoCarrello pc " +
        "WHERE pc.idCliente = :idCliente AND pc.idProdotto = :IdProdotto"
    )
    Integer getProdottoCarrelloFromIdProdottoAndIdCliente(Long idCliente, Long IdProdotto);

    @Transactional
    @Modifying
    @Query(
        "DELETE FROM ProdottoCarrello pc " +
        "WHERE pc.idCliente = :idCliente"
    )
    void deleteAllByIdCliente(Long idCliente);
    
}
