package it.studiomedico.apistudiomedico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMedico;

    private String name;

    private String surname;

    @Column(unique = true, name = "emailMedico",length = 100)
    private String email;

    @ManyToOne
    private Segretario segretario;

    @OneToMany(mappedBy = "medico")
    private List<Paziente> pazienti;

    @OneToMany(mappedBy = "medico")
    private List<Prenotazioni> prenotazioni;

    public Medico() {
    }

    public Medico(int idMedico, String name, String surname, String email) {
        this.idMedico = idMedico;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
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
