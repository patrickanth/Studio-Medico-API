package it.studiomedico.apistudiomedico.entitiesDTO;

import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.utilities.StatoPrenotazioneEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

public class PrenotazioniDTO extends Prenotazioni {

    private LocalDate dataPrenotazione = LocalDate.now();

    private StatoPrenotazioneEnum statoPrenotazione;

    private int idPaziente;

    private int idMedico;

    private String sedeVisita;

    public PrenotazioniDTO() {
    }

    public PrenotazioniDTO(int idPrenotazione, LocalDate dataPrenotazione, StatoPrenotazioneEnum statoPrenotazione, int idPaziente, int idMedico, String sedeVisita, Paziente paziente, LocalDate dataPrenotazione1, StatoPrenotazioneEnum statoPrenotazione1, int idPaziente1, int idMedico1, String sedeVisita1) {
        this.dataPrenotazione = dataPrenotazione1;
        this.statoPrenotazione = statoPrenotazione1;
        this.idPaziente = idPaziente1;
        this.idMedico = idMedico1;
        this.sedeVisita = sedeVisita1;
    }

    @Override
    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    @Override
    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    @Override
    public StatoPrenotazioneEnum getStatoPrenotazione() {
        return statoPrenotazione;
    }

    @Override
    public void setStatoPrenotazione(StatoPrenotazioneEnum statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }

    @Override
    public int getIdPaziente() {
        return idPaziente;
    }

    @Override
    public void setIdPaziente(int idPaziente) {
        this.idPaziente = idPaziente;
    }

    @Override
    public int getIdMedico() {
        return idMedico;
    }

    @Override
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    @Override
    public String getSedeVisita() {
        return sedeVisita;
    }

    @Override
    public void setSedeVisita(String sedeVisita) {
        this.sedeVisita = sedeVisita;
    }
}
