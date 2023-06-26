package com.grammatico.negozio.model.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    @Column(name = "idCliente", nullable = false)
    private Long idCliente;
    
    @Column(name = "tipo", nullable = false)
    private String tipo;
    
    @Column(name = "prezzoTotale", nullable = false)
    private int prezzoTotale; // un pò ridondante, si potrebbe ricavare da vendite
    
    @Column(name = "info")
    private String info;

    public Transazione() {}
    
    public Transazione(
        Date data,
        Long idCliente,
        String tipo,
        int prezzoTotale,
        String info
    ) {
        super();
        this.data = data;
        this.idCliente = idCliente;
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
    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    @Override
    public String toString() {
        return
            "Dipendente{" +
            "id=" + id +
            ", data=" + data +
            ", idCliente=" + idCliente +
            ", tipo=" + tipo +
            ", prezzoTotale=" + prezzoTotale +
            ", info=" + info +
            "}";
               
    }

}
