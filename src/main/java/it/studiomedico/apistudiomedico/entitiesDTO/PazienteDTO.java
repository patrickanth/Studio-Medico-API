package it.studiomedico.apistudiomedico.entitiesDTO;

import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.utilities.SessoEnum;

import java.util.Date;
import java.util.List;


public class PazienteDTO  {

    private String nomePaziente;

    private String cognomePaziente;

    private String emailPaziente;

    private String cellularePaziente;

    private String codiceFiscalePaziente;

    private Date dataDiNascitaPaziente;

    private String luogoDiNascitaPaziente;

    private SessoEnum sessoPaziente;

    private String descrizioneDelProblema;

    public PazienteDTO() {
    }

    public PazienteDTO(int idPaziente, String nomePaziente, String cognomePaziente, String emailPaziente, String cellularePaziente, String codiceFiscalePaziente, Date dataDiNascitaPaziente, String luogoDiNascitaPaziente, SessoEnum sessoPaziente, String descrizioneDelProblema, Medico medico, List<Prenotazioni> prenotazioniPaziente, String nomePaziente1, String cognomePaziente1, String emailPaziente1, String cellularePaziente1, String codiceFiscalePaziente1, Date dataDiNascitaPaziente1, String luogoDiNascitaPaziente1, SessoEnum sessoPaziente1, String descrizioneDelProblema1) {
        this.nomePaziente = nomePaziente;
        this.cognomePaziente = cognomePaziente;
        this.emailPaziente = emailPaziente;
        this.cellularePaziente = cellularePaziente;
        this.codiceFiscalePaziente = codiceFiscalePaziente;
        this.dataDiNascitaPaziente = dataDiNascitaPaziente;
        this.luogoDiNascitaPaziente = luogoDiNascitaPaziente;
        this.sessoPaziente = sessoPaziente;
        this.descrizioneDelProblema = descrizioneDelProblema;
    }


    public String getNomePaziente() {
        return nomePaziente;
    }


    public void setNomePaziente(String nomePaziente) {
        this.nomePaziente = nomePaziente;
    }


    public String getCognomePaziente() {
        return cognomePaziente;
    }


    public void setCognomePaziente(String cognomePaziente) {
        this.cognomePaziente = cognomePaziente;
    }


    public String getEmailPaziente() {
        return emailPaziente;
    }


    public void setEmailPaziente(String emailPaziente) {
        this.emailPaziente = emailPaziente;
    }


    public String getCellularePaziente() {
        return cellularePaziente;
    }


    public void setCellularePaziente(String cellularePaziente) {
        this.cellularePaziente = cellularePaziente;
    }


    public String getCodiceFiscalePaziente() {
        return codiceFiscalePaziente;
    }


    public void setCodiceFiscalePaziente(String codiceFiscalePaziente) {
        this.codiceFiscalePaziente = codiceFiscalePaziente;
    }


    public Date getDataDiNascitaPaziente() {
        return dataDiNascitaPaziente;
    }


    public void setDataDiNascitaPaziente(Date dataDiNascitaPaziente) {
        this.dataDiNascitaPaziente = dataDiNascitaPaziente;
    }


    public String getLuogoDiNascitaPaziente() {
        return luogoDiNascitaPaziente;
    }


    public void setLuogoDiNascitaPaziente(String luogoDiNascitaPaziente) {
        this.luogoDiNascitaPaziente = luogoDiNascitaPaziente;
    }


    public SessoEnum getSessoPaziente() {
        return sessoPaziente;
    }


    public void setSessoPaziente(SessoEnum sessoPaziente) {
        this.sessoPaziente = sessoPaziente;
    }


    public String getDescrizioneDelProblema() {
        return descrizioneDelProblema;
    }


    public void setDescrizioneDelProblema(String descrizioneDelProblema) {
        this.descrizioneDelProblema = descrizioneDelProblema;
    }
}
