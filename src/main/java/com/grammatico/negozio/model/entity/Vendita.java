package com.grammatico.negozio.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(
    name = "vendite"
)
@Entity(name = "Vendita")
public class Vendita {

    @Id // chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generata automaticamente e di tipo auto increment
    private Long id;
    
    @Column(name = "quantita", nullable = false)
    private int quantita;

    @Column(name = "id_transazione", nullable = false)
    private Long idTransazione;

    @Column(name = "id_prodotto", nullable = false)
    private Long idProdotto;
    
    
    public Vendita() {}
    
    public Vendita(
        int quantita
    ) {
        super();
        this.quantita = quantita;
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
    public Long getIdProdotto() {
        return idProdotto;
    }
    public void setIdProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }
    public Long getIdTransazione() {
        return idTransazione;
    }
    public void setIdTransazione(Long idTransazione) {
        this.idTransazione = idTransazione;
    }

    @Override
    public String toString() {
        return
            "Vendita{" +
            "id=" + id +
            ", quantita=" + quantita +
            ", id transazione=" + idTransazione +
            ", id prodotto=" + idProdotto +
            "}";
               
    }

}
