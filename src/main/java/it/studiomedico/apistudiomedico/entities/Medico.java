package it.studiomedico.apistudiomedico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medico")
public class Medico {

    /**@Medico  Questa è la tabella riguardante il complesso "medici", dove ogni singolo medico deve registrarsi
     * con i corrispettivi parametri:
     *
     * @idMedico
     * @nomeMedico
     * @cognomeMedico
     * @specializzazione
     * @emailMedico
     * @contattoUfficioMedico
     * @sedeDiLavoro
     * @giorniLavorativi
     *
     * @listaPazienti con questa lista ogni medico può tenere traccia di ogni paziente per il quale è stato incaricato.
     **/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "idMedico",length = 50)
    private int idMedico;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nomeMedico",length = 50)
    private String nomeMedico;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cognomeMedico",length = 50)
    private String cognomeMedico;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "specializzazione",length = 50)
    private String specializzazione;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "emailMedico",length = 100)
    private String emailMedico;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,name = "contattoUfficioMedico",length = 50)
    private int contattoUfficioMedico;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sedeDiLavoro",length = 50)
    private String sedeDiLavoro;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "giorniLavorativi",length = 50)
    private String giorniLavorativi;


  

    @ManyToOne
    private Segretario segretario;

    @OneToMany(mappedBy = "medico")
    private List<Paziente> listaPazienti;


    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCognomeMedico() {
        return cognomeMedico;
    }

    public void setCognomeMedico(String cognomeMedico) {
        this.cognomeMedico = cognomeMedico;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public String getEmailMedico() {
        return emailMedico;
    }

    public void setEmailMedico(String emailMedico) {
        this.emailMedico = emailMedico;
    }

    public int getContattoUfficioMedico() {
        return contattoUfficioMedico;
    }

    public void setContattoUfficioMedico(int contattoUfficioMedico) {
        this.contattoUfficioMedico = contattoUfficioMedico;
    }

    public String getSedeDiLavoro() {
        return sedeDiLavoro;
    }

    public void setSedeDiLavoro(String sedeDiLavoro) {
        this.sedeDiLavoro = sedeDiLavoro;
    }

    public String getGiorniLavorativi() {
        return giorniLavorativi;
    }

    public void setGiorniLavorativi(String giorniLavorativi) {
        this.giorniLavorativi = giorniLavorativi;
    }

    public Segretario getSegretario() {
        return segretario;
    }

    public void setSegretario(Segretario segretario) {
        this.segretario = segretario;
    }

    public List<Paziente> getListaPazienti() {
        return listaPazienti;
    }

    public void setListaPazienti(List<Paziente> listaPazienti) {
        this.listaPazienti = listaPazienti;
    }


    public Medico(int idMedico, String nomeMedico, String cognomeMedico, String specializzazione, String emailMedico,
                  int contattoUfficioMedico, String sedeDiLavoro, String giorniLavorativi,
                  Segretario segretario, List<Paziente> listaPazienti) {
        this.idMedico = idMedico;
        this.nomeMedico = nomeMedico;
        this.cognomeMedico = cognomeMedico;
        this.specializzazione = specializzazione;
        this.emailMedico = emailMedico;
        this.contattoUfficioMedico = contattoUfficioMedico;
        this.sedeDiLavoro = sedeDiLavoro;
        this.giorniLavorativi = giorniLavorativi;
        this.segretario = segretario;
        this.listaPazienti = listaPazienti;
    }

    public Medico(){}

}
