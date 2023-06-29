package com.grammatico.negozio.model.entity;

import java.sql.Date;
import java.util.List;

import com.grammatico.negozio.model.Genere;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Table(
    name = "clienti",
    uniqueConstraints = {
        @UniqueConstraint(name = "propietario_email_unique", columnNames = "email") // email unique
    }
)
@Entity(name = "Cliente")
public class Cliente {

    @Id // chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generata automaticamente e di tipo auto increment
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "cognome")
    private String cognome;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "numTelefono")
    private String numTelefono;
    
    @Column(name = "dataNascita")
    private Date dataNascita;
    
    @Column(name = "genere")
    @Enumerated(EnumType.STRING) // per definire la clonna genere come un enum (definito in Genere.java)
    private Genere genere;

    @OneToMany(targetEntity = Transazione.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private List<Transazione> transazioni;

    @OneToMany(targetEntity = Recenzione.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private List<Recenzione> recenzioni;
    
    
    public Cliente() {}
    
    public Cliente(
        String nome,
        String cognome,
        String email,
        String password,
        String numTelefono,
        Date dataNascita,
        Genere genere
    ) {
        super();
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.numTelefono = numTelefono;
        this.dataNascita = dataNascita;
        this.genere = genere;
    }

    public boolean isValid() { // ritorna true solo se tutte le condizioni sono verificate
        return
            nome != null && !nome.isEmpty() &&
            email != null && !email.isEmpty() &&
            password != null && !password.isEmpty();
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
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }
    public String getNumTelefono() {
        return numTelefono;
    }
    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Genere getGenere() {
        return genere;
    }
    public void setGenere(Genere genere) {
        this.genere = genere;
    }
    public List<Recenzione> getRecenzioni() {
        return recenzioni;
    }
    public void setRecenzioni(List<Recenzione> recenzioni) {
        this.recenzioni = recenzioni;
    }
    public List<Transazione> getTransazioni() {
        return transazioni;
    }
    public void setTransazioni(List<Transazione> transazioni) {
        this.transazioni = transazioni;
    }

    @Override
    public String toString() {
        return
            "Cliente{" +
            "id=" + id +
            ", nome=" + nome +
            ", cognome=" + cognome +
            ", email=" + email +
            ", password=" + password +
            ", numTelefono=" + numTelefono +
            ", dataNascita=" + dataNascita +
            "}";
               
    }

}
