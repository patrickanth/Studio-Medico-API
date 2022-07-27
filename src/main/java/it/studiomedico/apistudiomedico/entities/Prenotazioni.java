package it.studiomedico.apistudiomedico.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Prenotazioni")
public class Prenotazioni {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPrenotazione;

    private LocalDate date = LocalDate.now();

    private String state;

    @ManyToOne
    private Paziente paziente;

    @ManyToOne
    private Medico medico;

    public Prenotazioni() {
    }

    public Prenotazioni(int idPrenotazione, LocalDate date, String state) {
        this.idPrenotazione = idPrenotazione;
        this.date = date;
        this.state = state;
    }

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
