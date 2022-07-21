package it.studiomedico.apistudiomedico.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "Prenotazioni")
public class Prenotazioni {

    @Id
    private int idPrenotazione;
    private LocalDate date;
    private String state;
    private int idPaziente;
    private int idMedico;
}
