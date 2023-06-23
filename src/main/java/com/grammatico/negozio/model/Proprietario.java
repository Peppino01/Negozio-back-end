package com.grammatico.negozio.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Table(
    name = "propietari",
    uniqueConstraints = {
        @UniqueConstraint(name = "propietario_email_unique", columnNames = "email") // email unique
    }
)
@Entity(name = "Proprietario")
public class Proprietario {

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

    public Proprietario() {}
    
    public Proprietario(
        String nome,
        String cognome,
        String email,
        String password,
        String numTelefono,
        Date dataNascita
    ) {
        super();
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.numTelefono = numTelefono;
        this.dataNascita = dataNascita;
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
    public Date getdataNascita() {
        return dataNascita;
    }
    public void setdataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }
    public String getnumTelefono() {
        return numTelefono;
    }
    public void setnumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
            ", nome=" + nome +
            ", cognome=" + cognome +
            ", email=" + email +
            ", password=" + password +
            ", numTelefono=" + numTelefono +
            ", dataNascita=" + dataNascita +
            "}";
               
    }
    
    
}
