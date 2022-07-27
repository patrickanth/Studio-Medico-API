package it.studiomedico.apistudiomedico.entities;

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
    @Column(name = "idPrenotazione",length = 50)
    private int idPrenotazione;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dataPrenotazione",length = 50)
    private LocalDate dataPrenotazione = LocalDate.now();

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statoPrenotazione",length = 50)
    private String statoPrenotazione;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPaziente",length = 50)
    private int idPaziente;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMedico",length = 50)
    private int idMedico;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sedeVisita",length = 50)
    private String sedeVisita;

    @ManyToOne
    private Paziente paziente;

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

    public String getStatoPrenotazione() {
        return statoPrenotazione;
    }

    public void setStatoPrenotazione(String statoPrenotazione) {
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

    public Prenotazioni(int idPrenotazione, LocalDate dataPrenotazione, String statoPrenotazione,
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
