package it.studiomedico.apistudiomedico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Paziente ")
public class Paziente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPaziente;

    private String name;

    private String surname;

    @Column(unique = true, name = "emailPaziente",length = 100)
    private String email;

    @ManyToOne
    private Medico medico;

    @OneToMany(mappedBy = "Paziente")
    private List<Prenotazioni> prenotazioni;

    public Paziente() {
    }

    public Paziente(int idPaziente, String name, String surname, String email) {
        this.idPaziente = idPaziente;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getIdPaziente() {
        return idPaziente;
    }

    public void setIdPaziente(int idPaziente) {
        this.idPaziente = idPaziente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
