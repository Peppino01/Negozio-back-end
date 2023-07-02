package com.grammatico.negozio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grammatico.negozio.DTO.outputDTO.ProdottoInventarioOutputDTO;
import com.grammatico.negozio.model.StatoProdotto;
import com.grammatico.negozio.model.entity.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

    @Query(
        "SELECT new com.grammatico.negozio.DTO.outputDTO.ProdottoInventarioOutputDTO(p.nome, i.stato, i.quantita, p.prezzo, p.descrizione) " +
        "FROM Prodotto p " +
        "JOIN p.inventario i " +
        "WHERE i.stato = :stato"
    )
    List<ProdottoInventarioOutputDTO> getProdottiInventarioFromStato(StatoProdotto stato);

    @Query(
        "SELECT new com.grammatico.negozio.DTO.outputDTO.ProdottoInventarioOutputDTO(p.nome, i.stato, i.quantita, p.prezzo, p.descrizione) " +
        "FROM Prodotto p " +
        "JOIN p.inventario i "
    )
    List<ProdottoInventarioOutputDTO> getAllProdottiInventario();

    boolean existsByNome(String nome);
    
}
