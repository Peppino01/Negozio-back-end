package com.grammatico.negozio.model;

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

    public Date getdata() {
        return data;
    }
    public void setdata(Date data) {
        this.data = data;
    }
    public Long getidCliente() {
        return idCliente;
    }
    public void setidCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    public String gettipo() {
        return tipo;
    }
    public void settipo(String tipo) {
        this.tipo = tipo;
    }
    public String getinfo() {
        return info;
    }
    public void setinfo(String info) {
        this.info = info;
    }
    public int getprezzoTotale() {
        return prezzoTotale;
    }
    public void setprezzoTotale(int prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
