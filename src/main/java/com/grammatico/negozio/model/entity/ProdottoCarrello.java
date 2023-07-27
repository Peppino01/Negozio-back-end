package com.grammatico.negozio.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// il carrello è una lista di prodottiCarrello
@Table(
    name = "carrello"
)
@Entity(name = "ProdottoCarrello")
public class ProdottoCarrello {

    @Id // chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generata automaticamente e di tipo auto increment
    private Long id;

    @Column(name = "quantita", nullable = false)
    private int quantita;

    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    @Column(name = "id_prodotto", nullable = false)
    private Long idProdotto;
    
    
    public ProdottoCarrello() {}
    
    public ProdottoCarrello(
        int quantita,
        Long idCliente,
        Long idProdotto
    ) {
        super();
        this.quantita = quantita;
        this.idCliente = idCliente;
        this.idProdotto = idProdotto;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getQuantita() {
        return quantita;
    }
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    public Long getIdProdotto() {
        return idProdotto;
    }
    public void setIdProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }

    @Override
    public String toString() {
        return
            "Cliente{" +
            "id=" + id +
            ", quantita=" + quantita +
            ", idCliente=" + idCliente +
            ", idProdotto=" + idProdotto +
            "}";
    }

}
