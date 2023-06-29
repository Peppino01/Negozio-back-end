package com.grammatico.negozio.model.entity;

import com.grammatico.negozio.model.StatoProdotto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(
    name = "inventario"
)
@Entity(name = "Inventario")
public class Inventario {

    @Id // chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generata automaticamente e di tipo auto increment
    private Long id;

    @Column(name = "quantita", nullable = false)
    private int quantita;
    
    @Column(name = "stato")
    @Enumerated(EnumType.STRING) // per definire la clonna stato come un enum (definito in StatoProdotto.java)
    private StatoProdotto stato;


    public Inventario() {}

    public Inventario(
        int quantità,
        StatoProdotto stato,
        Prodotto prodotto
    ) {
        this.quantita = quantità;
        this.stato = stato;
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
    public StatoProdotto getStato() {
        return stato;
    }
    public void setStato(StatoProdotto stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return
            "Inventario{" +
            "id=" + id +
            ", prezzo=" + quantita +
            ", descrizione=" + stato +
            "}";
               
    }
    
}
