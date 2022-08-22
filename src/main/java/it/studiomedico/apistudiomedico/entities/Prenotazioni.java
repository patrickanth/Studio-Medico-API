package it.studiomedico.apistudiomedico.entities;

import it.studiomedico.apistudiomedico.utilities.StatoPrenotazioneEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "prenotazioni")
public class Prenotazioni {

    /**@Prenotazioni Tabella usata per unire le entità Medico,Paziente e Segretario.
     * Viene utilizzata come punto di riferimento per le imformative delle prenotazioni.
     *
     * @idPrenotazione
     * @dataPrenotazione
     * @statoPrenotazione
     * @statoPrenotazione
     * @idPaziente riferimento alla tabella Paziente
     * @idMedico riferimento alla tabella Medico
     * @sedeVisita
     *
     * @paziente Questo oggetto di tipo "Paziente" accompagnato dall'annotazione ManyToOne serve  principalmente
     * per dare la possibilità ad un paziente di avere più di una prenotazione a carico.
     **/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_prenotazione",length = 50)
    private int idPrenotazione;


    @Column(name = "data_prenotazione",length = 50)
    private LocalDate dataPrenotazione = LocalDate.now();


    @Column(name = "stato_prenotazione",length = 50)
    @Enumerated(EnumType.STRING)
    private StatoPrenotazioneEnum statoPrenotazione;


    @Column(name = "id_paziente",length = 50)
    private int idPaziente;


    @Column(name = "id_medico",length = 50)
    private int idMedico;


    @Column(name = "sede_visita",length = 50)
    private String sedeVisita;

    @ManyToOne
    private Paziente paziente;

    @ManyToOne
    private Medico medico;


    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
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

    public Paziente getPaziente() {
        return paziente;
    }

    public void setPaziente(Paziente paziente) {
        this.paziente = paziente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Prenotazioni(int idPrenotazione, LocalDate dataPrenotazione, StatoPrenotazioneEnum statoPrenotazione,
                        int idPaziente, int idMedico, String sedeVisita, Paziente paziente) {
        this.idPrenotazione = idPrenotazione;
        this.dataPrenotazione = dataPrenotazione;
        this.statoPrenotazione = statoPrenotazione;
        this.idPaziente = idPaziente;
        this.idMedico = idMedico;
        this.sedeVisita = sedeVisita;
        this.paziente = paziente;
    }

    public Prenotazioni(){}

}
