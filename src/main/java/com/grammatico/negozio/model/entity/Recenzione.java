package com.grammatico.negozio.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(
    name = "recenzioni"
)
@Entity(name = "Recenzione")
public class Recenzione {

    @Id // chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generata automaticamente e di tipo auto increment
    private Long id;

    @Column(name = "dataPubblicazione", nullable = false)
    private Date dataPubblicazione;
    
    @Column(name = "valutazione", nullable = false)
    private int valutazione;
    
    @Column(name = "commento")
    private String commento;

    
    public Recenzione() {}
    
    public Recenzione(
        Date dataPubblicazione,
        int valutazione,
        String commento
    ) {
        super();
        this.dataPubblicazione = dataPubblicazione;
        this.valutazione = valutazione;
        this.commento = commento;
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

    @Override
    public String toString() {
        return
            "Recenzione{" +
            "id=" + id +
            ", dataPubblicazione=" + dataPubblicazione +
            ", valutazione=" + valutazione +
            ", commento=" + commento +
            "}";
               
    }
    
    
}
