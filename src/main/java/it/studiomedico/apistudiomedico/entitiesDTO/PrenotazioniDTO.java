package it.studiomedico.apistudiomedico.entitiesDTO;

import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.utilities.StatoPrenotazioneEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

public class PrenotazioniDTO  {

    /**
     * @PrenotazioniDTO va a prendere nel caso ci fosse bisogno dei parametri in input limitati.
     */
    private LocalDate dataPrenotazione = LocalDate.now();

    private StatoPrenotazioneEnum statoPrenotazione;

    private int idPaziente;

    private int idMedico;

    private String sedeVisita;

    public PrenotazioniDTO() {
    }

    public PrenotazioniDTO( StatoPrenotazioneEnum statoPrenotazione, int idPaziente, int idMedico,
                           String sedeVisita) {
        this.statoPrenotazione = statoPrenotazione;
        this.idPaziente = idPaziente;
        this.idMedico = idMedico;
        this.sedeVisita = sedeVisita;
    }


    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }


    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }


    public StatoPrenotazioneEnum getStatoPrenotazione() {
        return statoPrenotazione;
    }


    public void setStatoPrenotazione(StatoPrenotazioneEnum statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }


    public int getIdPaziente() {
        return idPaziente;
    }


    public void setIdPaziente(int idPaziente) {
        this.idPaziente = idPaziente;
    }


    public int getIdMedico() {
        return idMedico;
    }


    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }


    public String getSedeVisita() {
        return sedeVisita;
    }


    public void setSedeVisita(String sedeVisita) {
        this.sedeVisita = sedeVisita;
    }
}
