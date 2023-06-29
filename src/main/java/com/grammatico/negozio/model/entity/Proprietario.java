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
import jakarta.persistence.UniqueConstraint;


@Table(
    name = "proprietari",
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

    @OneToMany(targetEntity = Dipendente.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_proprietario", referencedColumnName = "id")
    private List<Dipendente> dipendenti;
    

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
    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }
    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    @Override
    public String toString() {
        return
            "Proprietario{" +
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
