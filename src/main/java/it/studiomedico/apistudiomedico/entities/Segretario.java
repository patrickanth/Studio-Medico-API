package it.studiomedico.apistudiomedico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Segretario")
public class Segretario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iDSegretario;

    private String name;

    private String surname;

    @Column(unique = true, name = "emailSegretario",length = 100)
    private String email;


    @OneToMany(mappedBy = "Segretario")
    private List<Medico> medici;

    public Segretario() {
    }

    public Segretario(int iDSegretario, String name, String surname, String email) {
        this.iDSegretario = iDSegretario;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getiDSegretario() {
        return iDSegretario;
    }

    public void setiDSegretario(int iDSegretario) {
        this.iDSegretario = iDSegretario;
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
