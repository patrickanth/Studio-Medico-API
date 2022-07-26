package it.studiomedico.apistudiomedico.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Prenotazioni")
public class Prenotazioni {

    @Id
    private int idPrenotazione;
    private LocalDate date = LocalDate.now();
    private String state;
    private int idPaziente;
    private int idMedico;

    @ManyToOne
    private Paziente paziente;

}
