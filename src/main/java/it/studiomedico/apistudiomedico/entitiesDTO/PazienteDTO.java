package it.studiomedico.apistudiomedico.entitiesDTO;

import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.utilities.SessoEnum;

import java.util.Date;
import java.util.List;


public class PazienteDTO extends Paziente {

    private String nomePaziente;

    private String cognomePaziente;

    private String emailPaziente;

    private String cellularePaziente;

    private String codiceFiscalePaziente;

    private Date dataDiNascitaPaziente;

    private String luogoDiNascitaPaziente;

    private SessoEnum sessoPaziente;

    private String descrizioneDelProblema;

    public PazienteDTO(String nomePaziente) {
    }

    public PazienteDTO(int idPaziente, String nomePaziente, String cognomePaziente, String emailPaziente, String cellularePaziente, String codiceFiscalePaziente, Date dataDiNascitaPaziente, String luogoDiNascitaPaziente, SessoEnum sessoPaziente, String descrizioneDelProblema, Medico medico, List<Prenotazioni> prenotazioniPaziente, String nomePaziente1, String cognomePaziente1, String emailPaziente1, String cellularePaziente1, String codiceFiscalePaziente1, Date dataDiNascitaPaziente1, String luogoDiNascitaPaziente1, SessoEnum sessoPaziente1, String descrizioneDelProblema1) {
        this.nomePaziente = nomePaziente1;
        this.cognomePaziente = cognomePaziente1;
        this.emailPaziente = emailPaziente1;
        this.cellularePaziente = cellularePaziente1;
        this.codiceFiscalePaziente = codiceFiscalePaziente1;
        this.dataDiNascitaPaziente = dataDiNascitaPaziente1;
        this.luogoDiNascitaPaziente = luogoDiNascitaPaziente1;
        this.sessoPaziente = sessoPaziente1;
        this.descrizioneDelProblema = descrizioneDelProblema1;
    }

    @Override
    public String getNomePaziente() {
        return nomePaziente;
    }

    @Override
    public void setNomePaziente(String nomePaziente) {
        this.nomePaziente = nomePaziente;
    }

    @Override
    public String getCognomePaziente() {
        return cognomePaziente;
    }

    @Override
    public void setCognomePaziente(String cognomePaziente) {
        this.cognomePaziente = cognomePaziente;
    }

    @Override
    public String getEmailPaziente() {
        return emailPaziente;
    }

    @Override
    public void setEmailPaziente(String emailPaziente) {
        this.emailPaziente = emailPaziente;
    }

    @Override
    public String getCellularePaziente() {
        return cellularePaziente;
    }

    @Override
    public void setCellularePaziente(String cellularePaziente) {
        this.cellularePaziente = cellularePaziente;
    }

    @Override
    public String getCodiceFiscalePaziente() {
        return codiceFiscalePaziente;
    }

    @Override
    public void setCodiceFiscalePaziente(String codiceFiscalePaziente) {
        this.codiceFiscalePaziente = codiceFiscalePaziente;
    }

    @Override
    public Date getDataDiNascitaPaziente() {
        return dataDiNascitaPaziente;
    }

    @Override
    public void setDataDiNascitaPaziente(Date dataDiNascitaPaziente) {
        this.dataDiNascitaPaziente = dataDiNascitaPaziente;
    }

    @Override
    public String getLuogoDiNascitaPaziente() {
        return luogoDiNascitaPaziente;
    }

    @Override
    public void setLuogoDiNascitaPaziente(String luogoDiNascitaPaziente) {
        this.luogoDiNascitaPaziente = luogoDiNascitaPaziente;
    }

    @Override
    public SessoEnum getSessoPaziente() {
        return sessoPaziente;
    }

    @Override
    public void setSessoPaziente(SessoEnum sessoPaziente) {
        this.sessoPaziente = sessoPaziente;
    }

    @Override
    public String getDescrizioneDelProblema() {
        return descrizioneDelProblema;
    }

    @Override
    public void setDescrizioneDelProblema(String descrizioneDelProblema) {
        this.descrizioneDelProblema = descrizioneDelProblema;
    }
}
