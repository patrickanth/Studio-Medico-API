package it.studiomedico.apistudiomedico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Segretario")
public class Segretario {
    @Id
    @OneToMany( fetch = FetchType.LAZY)
    private int iDSegretario;
    private String name;
    private String surname;
    @Column(unique = true, name = "emailSegretario",length = 100)
    private String email;


}