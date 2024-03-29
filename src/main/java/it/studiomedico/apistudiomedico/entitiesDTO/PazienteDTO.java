package it.studiomedico.apistudiomedico.entitiesDTO;

import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.utilities.SessoEnum;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class PazienteDTO  {

    /**
     * @PazienteDTO va a prendere nel caso ci fosse bisogno dei parametri in input limitati.
     */
    private String nomePaziente;

    private String cognomePaziente;

    private String emailPaziente;

    private String cellularePaziente;

    private String codiceFiscalePaziente;

    private LocalDate dataDiNascitaPaziente;

    private String luogoDiNascitaPaziente;

    private SessoEnum sessoPaziente;

    private String descrizioneDelProblema;

    public PazienteDTO() {
    }

    public PazienteDTO(String nomePaziente, String cognomePaziente, String emailPaziente,
                       String cellularePaziente, String codiceFiscalePaziente, LocalDate dataDiNascitaPaziente,
                       String luogoDiNascitaPaziente, SessoEnum sessoPaziente, String descrizioneDelProblema){
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


    public LocalDate getDataDiNascitaPaziente() {
        return dataDiNascitaPaziente;
    }


    public void setDataDiNascitaPaziente(LocalDate dataDiNascitaPaziente) {
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
