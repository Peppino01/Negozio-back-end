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

    @Column(name = "idTransazione", nullable = false)
    private Long idTransazione;
    
    @Column(name = "idProdotto", nullable = false)
    private Long idProdotto;
    
    @Column(name = "quantita", nullable = false)
    private int quantita;
    
    @Column(name = "prezzoUnitario", nullable = false)
    private int prezzoUnitario;
    
    public Vendita() {}
    
    public Vendita(
        Long idTransazione,
        Long idProdotto,
        int quantita,
        int prezzoUnitario
    ) {
        super();
        this.idTransazione = idTransazione;
        this.idProdotto = idProdotto;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getidTransazione() {
        return idTransazione;
    }
    public void setidTransazione(Long idTransazione) {
        this.idTransazione = idTransazione;
    }
    public Long getidProdotto() {
        return idProdotto;
    }
    public void setidProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }
    public int getquantita() {
        return quantita;
    }
    public void setquantita(int quantita) {
        this.quantita = quantita;
    }
    public int getprezzoUnitario() {
        return prezzoUnitario;
    }
    public void setprezzoUnitario(int prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    @Override
    public String toString() {
        return
            "Dipendente{" +
            "id=" + id +
            ", idTransazione=" + idTransazione +
            ", idProdotto=" + idProdotto +
            ", quantita=" + quantita +
            ", prezzoUnitario=" + prezzoUnitario +
            "}";
               
    }

}
