package com.develhope.studiomedico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMedico;

    private String name;
    private String surname;
    private String email;

    @ManyToOne
    private Segretario segretario;

    @OneToMany(mappedBy = "medico")
    private List<Paziente> pazienti;

}
