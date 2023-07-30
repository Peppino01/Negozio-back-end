package com.grammatico.negozio.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Table(
    name = "prodotti",
    uniqueConstraints = {
        @UniqueConstraint(name = "prodotto_nome_unique", columnNames = "nome") // nome unique
    }
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

    @OneToMany(targetEntity = Vendita.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prodotto", referencedColumnName = "id")
    private List<Vendita> vendite;

    @OneToMany(targetEntity = Recensione.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prodotto", referencedColumnName = "id")
    private List<Recensione> recensioni;

    @OneToMany(targetEntity = Inventario.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prodotto", referencedColumnName = "id")
    private List<Inventario> inventario;
    
    @OneToMany(targetEntity = ProdottoCarrello.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prodotto", referencedColumnName = "id")
    private List<ProdottoCarrello> carrello;
    
    
    public Prodotto() {}
    
    public Prodotto(
        String nome,
        int prezzo,
        String descrizione
    ) {
        super();
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
    }

    public Prodotto(
        String nome,
        int prezzo,
        String descrizione,
        List<Vendita> vendite,
        List<Recensione> recensioni,
        List<Inventario> inventario
    ) {
        super();
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.vendite = vendite;
        this.recensioni = recensioni;
        this.inventario = inventario;
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
    public List<Inventario> getInventario() {
        return inventario;
    }
    public void setInventario(List<Inventario> inventario) {
        this.inventario = inventario;
    }
    public List<Recensione> getRecensioni() {
        return recensioni;
    }
    public void setRecensioni(List<Recensione> recensioni) {
        this.recensioni = recensioni;
    }
    public List<Vendita> getVendite() {
        return vendite;
    }
    public void setVendite(List<Vendita> vendite) {
        this.vendite = vendite;
    }
    public List<ProdottoCarrello> getCarrello() {
        return carrello;
    }
    public void setCarrello(List<ProdottoCarrello> carrello) {
        this.carrello = carrello;
    }

    @Override
    public String toString() {
        return
            "Prodotto{" +
            "id=" + id +
            ", nome=" + nome +
            ", prezzo=" + prezzo +
            ", descrizione=" + descrizione +
            ", nome=" + vendite +
            ", prezzo=" + recensioni +
            ", descrizione=" + inventario +
            ", carrello=" + carrello +
            "}";
               
    }

}
