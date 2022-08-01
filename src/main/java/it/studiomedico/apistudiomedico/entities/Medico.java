package it.studiomedico.apistudiomedico.entities;

import it.studiomedico.apistudiomedico.utilities.GiorniLavorativiEnum;
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


    @Column(name = "nomeMedico",length = 50)
    private String nomeMedico;


    @Column(name = "cognomeMedico",length = 50)
    private String cognomeMedico;


    @Column(name = "specializzazione",length = 50)
    private String specializzazione;


    @Column(unique = true, name = "emailMedico",length = 100)
    private String emailMedico;


    @Column(unique = true,name = "contattoUfficioMedico",length = 15)
    private String contattoUfficioMedico;


    @Column(name = "sedeDiLavoro",length = 50)
    private String sedeDiLavoro;


    @Column(name = "giorniLavorativi",length = 50)
    private GiorniLavorativiEnum giorniLavorativi;


  

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

    public String getContattoUfficioMedico() {
        return contattoUfficioMedico;
    }

    public void setContattoUfficioMedico(String contattoUfficioMedico) {
        this.contattoUfficioMedico = contattoUfficioMedico;
    }

    public String getSedeDiLavoro() {
        return sedeDiLavoro;
    }

    public void setSedeDiLavoro(String sedeDiLavoro) {
        this.sedeDiLavoro = sedeDiLavoro;
    }

    public GiorniLavorativiEnum getGiorniLavorativi() {
        return giorniLavorativi;
    }

    public void setGiorniLavorativi(GiorniLavorativiEnum giorniLavorativi) {
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
                  String contattoUfficioMedico, String sedeDiLavoro, GiorniLavorativiEnum giorniLavorativi,
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
