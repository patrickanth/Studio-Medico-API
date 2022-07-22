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
public class Paziente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPaziente;

    private String name;
    private String surname;
    private String email;

    @ManyToOne
    private Medico medico;

    @OneToMany(mappedBy = "paziente")
    private List<Prenotazione> prenotazioni;

}
