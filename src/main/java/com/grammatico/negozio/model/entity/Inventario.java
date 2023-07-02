package com.grammatico.negozio.model.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.grammatico.negozio.DTO.inputDTO.InventarioInputDTO;
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
        StatoProdotto stato
    ) {
        this.quantita = quantità;
        this.stato = stato;
    }

    public Inventario(
        Long id,
        int quantità,
        StatoProdotto stato
    ) {
        this.id = id;
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

    public static boolean validForOneProdotto(List<Inventario> inventario) {
        // controllo se gli inventari inviati sono 4
        if (inventario.size() != 4) {
            System.out.println("Un inventario prodotto deve avere 4 elementi");
            return false;
        }
        
        // controllo che tutti gli stati e gli id siano diversi
        List<StatoProdotto> statiControllati = new ArrayList<>();
        List<Long> idControllati = new ArrayList<>();
        for (Inventario inv : inventario) {
            if (statiControllati.contains(inv.getStato())) {
                System.out.println("Un inventario prodotto non può avere più di un tipo di stato");
                return false;
            } else if (idControllati.contains(inv.getId())) {
                if (inv.getId() != null) {
                    System.out.println("Un inventario prodotto deve riferirsi solo ad un prodotto");
                    return false;
                }
            } else {
                statiControllati.add(inv.getStato());
                idControllati.add(inv.getId());
            }
        }

        // controllo che tutte le quantità non siano negative
        for (Inventario inv : inventario) {
            if (inv.getQuantita() < 0) {
                System.out.println("La quantità non può essere minore di zero");
                return false;
            }
        }

        // se tutto va bene
        return true;
    }
    
}
