package com.grammatico.negozio.model.entity;

import java.sql.Date;
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


@Table(
    name = "transazioni"
)
@Entity(name = "Transazione")
public class Transazione {

    @Id // chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generata automaticamente e di tipo auto increment
    private Long id;

    @Column(name = "data", nullable = false)
    private Date data;
    
    @Column(name = "tipo", nullable = false)
    private String tipo;
    
    @Column(name = "prezzoTotale", nullable = false)
    private int prezzoTotale; // un pò ridondante, si potrebbe ricavare da vendite
    
    @Column(name = "info")
    private String info;

    @OneToMany(targetEntity = Vendita.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transazione", referencedColumnName = "id")
    private List<Vendita> vendite;
    

    public Transazione() {}
    
    public Transazione(
        Date data,
        String tipo,
        int prezzoTotale,
        String info
    ) {
        super();
        this.data = data;
        this.tipo = tipo;
        this.prezzoTotale = prezzoTotale;
        this.info = info;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public int getPrezzoTotale() {
        return prezzoTotale;
    }
    public void setPrezzoTotale(int prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }
    public List<Vendita> getVendite() {
        return vendite;
    }
    public void setVendite(List<Vendita> vendite) {
        this.vendite = vendite;
    }

    @Override
    public String toString() {
        return
            "Transazione{" +
            "id=" + id +
            ", data=" + data +
            ", tipo=" + tipo +
            ", prezzoTotale=" + prezzoTotale +
            ", info=" + info +
            "}";
               
    }

}
