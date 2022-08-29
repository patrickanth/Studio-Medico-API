package it.studiomedico.apistudiomedico.entitiesDTO;

import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.utilities.GiorniLavorativiEnum;

public class SegretarioDTO{
    private String nomeSegretario;

    private String cognomeSegretario;

    private String emailSegretario;

    private String contattoUfficioSegretario;

    private String sedeDiLavoro;

    private GiorniLavorativiEnum giorniLavorativi;

    public SegretarioDTO() {}

    public SegretarioDTO(String nomeSegretario, String cognomeSegretario, String emailSegretario, String contattoUfficioSegretario, String sedeDiLavoro, GiorniLavorativiEnum giorniLavorativi) {
        this.nomeSegretario = nomeSegretario;
        this.cognomeSegretario = cognomeSegretario;
        this.emailSegretario = emailSegretario;
        this.contattoUfficioSegretario = contattoUfficioSegretario;
        this.sedeDiLavoro = sedeDiLavoro;
        this.giorniLavorativi = giorniLavorativi;
    }

    public String getNomeSegretario() {
        return nomeSegretario;
    }

    public void setNomeSegretario(String nomeSegretario) {
        this.nomeSegretario = nomeSegretario;
    }

    public String getCognomeSegretario() {
        return cognomeSegretario;
    }

    public void setCognomeSegretario(String cognomeSegretario) {
        this.cognomeSegretario = cognomeSegretario;
    }

    public String getEmailSegretario() {
        return emailSegretario;
    }

    public void setEmailSegretario(String emailSegretario) {
        this.emailSegretario = emailSegretario;
    }

    public String getContattoUfficioSegretario() {
        return contattoUfficioSegretario;
    }

    public void setContattoUfficioSegretario(String contattoUfficioSegretario) {
        this.contattoUfficioSegretario = contattoUfficioSegretario;
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
