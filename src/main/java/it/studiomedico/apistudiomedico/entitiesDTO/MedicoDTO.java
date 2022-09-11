package it.studiomedico.apistudiomedico.entitiesDTO;

import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.utilities.GiorniLavorativiEnum;

import java.util.List;


public class MedicoDTO{

    private String nomeMedico;

    private String cognomeMedico;

    private String specializzazione;

    private String emailMedico;

    private String contattoUfficioMedico;

    private String sedeDiLavoro;

    private GiorniLavorativiEnum giorniLavorativi;

    public MedicoDTO() {
    }

    public MedicoDTO(String nomeMedico, String cognomeMedico, String specializzazione, String emailMedico,
                     String contattoUfficioMedico, String sedeDiLavoro, GiorniLavorativiEnum giorniLavorativi) {
        this.nomeMedico = nomeMedico;
        this.cognomeMedico = cognomeMedico;
        this.specializzazione = specializzazione;
        this.emailMedico = emailMedico;
        this.contattoUfficioMedico = contattoUfficioMedico;
        this.sedeDiLavoro = sedeDiLavoro;
        this.giorniLavorativi = giorniLavorativi;
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


}
