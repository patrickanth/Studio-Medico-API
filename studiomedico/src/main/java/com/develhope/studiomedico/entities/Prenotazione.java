package com.develhope.studiomedico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPrenotazione;

    private String name;
    private String surname;
    private String email;

    @ManyToOne
    private Paziente paziente;

}
