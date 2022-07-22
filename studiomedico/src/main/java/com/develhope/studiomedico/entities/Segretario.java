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
public class Segretario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSegretario;

    private String name;
    private String surname;
    private String email;

    @OneToMany(mappedBy = "segretario")
    private List<Medico> medici;

}
