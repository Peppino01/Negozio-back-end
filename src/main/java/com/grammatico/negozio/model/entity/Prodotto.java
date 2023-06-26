package com.grammatico.negozio.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(
    name = "prodotti"
)
@Entity(name = "Prodotto")
public class Prodotto {

    @Id // chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generata automaticamente e di tipo auto increment
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "prezzo", nullable = false)
    private int prezzo;
    
    @Column(name = "descrizione")
    private String descrizione;
    
    @Column(name = "quantita", nullable = false)
    private int quantita;
    
    @Column(name = "stato", nullable = false)
    private String stato;
    
    public Prodotto() {}
    
    public Prodotto(
        String nome,
        int prezzo,
        String descrizione,
        int quantita,
        String stato
    ) {
        super();
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.stato = stato;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public String getStato() {
        return stato;
    }
    public void setStato(String stato) {
        this.stato = stato;
    }
    public int getQuantita() {
        return quantita;
    }
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return
            "Dipendente{" +
            "id=" + id +
            ", nome=" + nome +
            ", prezzo=" + prezzo +
            ", descrizione=" + descrizione +
            ", quantita=" + quantita +
            ", stato=" + stato +
            "}";
               
    }

}
