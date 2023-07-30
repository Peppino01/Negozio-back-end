package com.grammatico.negozio.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(
    name = "recensioni"
)
@Entity(name = "Recensione")
public class Recensione {

    @Id // chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generata automaticamente e di tipo auto increment
    private Long id;

    @Column(name = "dataPubblicazione", nullable = false)
    private Date dataPubblicazione;
    
    @Column(name = "valutazione", nullable = false)
    private int valutazione;
    
    @Column(name = "commento")
    private String commento;

    @Column(name = "id_prodotto")
    private Long idProdotto;

    @Column(name = "id_cliente")
    private Long idCliente;

    
    public Recensione() {}
    
    public Recensione(
        Date dataPubblicazione,
        int valutazione,
        String commento,
        Long idProdotto,
        Long idCliente
    ) {
        super();
        this.dataPubblicazione = dataPubblicazione;
        this.valutazione = valutazione;
        this.commento = commento;
        this.idProdotto = idProdotto;
        this.idCliente = idCliente;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDataPubblicazione() {
        return dataPubblicazione;
    }
    public void setDataPubblicazione(Date dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }
    public int getValutazione() {
        return valutazione;
    }
    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }
    public String getCommento() {
        return commento;
    }
    public void setCommento(String commento) {
        this.commento = commento;
    }
    public Long getIdProdotto() {
        return idProdotto;
    }
    public void setIdProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }
    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    

    @Override
    public String toString() {
        return
            "Recensione{" +
            "id=" + id +
            ", dataPubblicazione=" + dataPubblicazione +
            ", valutazione=" + valutazione +
            ", commento=" + commento +
            ", idProdotto=" + idProdotto +
            ", idCliente=" + idCliente +
            "}"; 
    }
    
}
