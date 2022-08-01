package it.studiomedico.apistudiomedico.entities;

import it.studiomedico.apistudiomedico.utilities.SessoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paziente ")
public class Paziente {

    /**@Paziente Questa è la tabella riguardante il complesso "pazienti", dove ogni singolo individuo può compilare
     * una registrazione con i corrispettivi parametri:
     *
     * @idPazionte
     * @nomePaziente
     * @cognomePaziente
     * @emailPaziente
     * @cellularePaziente
     * @codiceFiscalePaziente
     * @dataDiNascitaPaziente
     * @luogoDiNascitaPaziente
     * @sessoPaziente
     * @descrizioneDelProblema
     *
     *
     * @prenotazioniPazienti Tutte le richieste verranno inserite dentro alla lista delle prenotazioni
    **/
    @Id
    @Column(name = "idPaziente",length = 50)
    private int idPaziente;


    @Column(name = "nomePaziente",length = 50)
    private String nomePaziente;


    @Column(name = "cognomePaziente",length = 50)
    private String cognomePaziente;


    @Column(unique = true, name = "emailPaziente",length = 100)
    private String emailPaziente;

    @Column(unique = true,name = "cellularePaziente",length = 50)
    private String cellularePaziente;


    @Column(unique = true,name = "codiceFiscalePaziente",length = 100)
    private String codiceFiscalePaziente;


    @Column(name = "dataDiNascitaPaziente",length = 50)
    private Date dataDiNascitaPaziente;


    @Column(name = "luogoDiNascitaPaziente",length = 50)
    private String luogoDiNascitaPaziente;


    @Column(name = "sessoPaziente",length = 50)
    private SessoEnum sessoPaziente;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "descrizioneDelProblema",length = 250)
    private String descrizioneDelProblema;

    @ManyToOne
    private Medico medico;


    @OneToMany(mappedBy = "paziente")
    private List<Prenotazioni> prenotazioniPaziente;

    public int getIdPaziente() {
        return idPaziente;
    }

    public String getNomePaziente() {
        return nomePaziente;
    }

    public String getCognomePaziente() {
        return cognomePaziente;
    }

    public String getEmailPaziente() {
        return emailPaziente;
    }

    public String getCellularePaziente() {
        return cellularePaziente;
    }

    public String getCodiceFiscalePaziente() {
        return codiceFiscalePaziente;
    }

    public Date getDataDiNascitaPaziente() {
        return dataDiNascitaPaziente;
    }

    public String getLuogoDiNascitaPaziente() {
        return luogoDiNascitaPaziente;
    }

    public SessoEnum getSessoPaziente() {
        return sessoPaziente;
    }

    public String getDescrizioneDelProblema() {
        return descrizioneDelProblema;
    }

    public Medico getMedico() {
        return medico;
    }

    public List<Prenotazioni> getPrenotazioniPaziente() {
        return prenotazioniPaziente;
    }

    public void setIdPaziente(int idPaziente) {
        this.idPaziente = idPaziente;
    }

    public void setNomePaziente(String nomePaziente) {
        this.nomePaziente = nomePaziente;
    }

    public void setCognomePaziente(String cognomePaziente) {
        this.cognomePaziente = cognomePaziente;
    }

    public void setEmailPaziente(String emailPaziente) {
        this.emailPaziente = emailPaziente;
    }

    public void setCellularePaziente(String cellularePaziente) {
        this.cellularePaziente = cellularePaziente;
    }

    public void setCodiceFiscalePaziente(String codiceFiscalePaziente) {
        this.codiceFiscalePaziente = codiceFiscalePaziente;
    }

    public void setDataDiNascitaPaziente(Date dataDiNascitaPaziente) {
        this.dataDiNascitaPaziente = dataDiNascitaPaziente;
    }

    public void setLuogoDiNascitaPaziente(String luogoDiNascitaPaziente) {
        this.luogoDiNascitaPaziente = luogoDiNascitaPaziente;
    }

    public void setSessoPaziente(SessoEnum sessoPaziente) {
        this.sessoPaziente = sessoPaziente;
    }

    public void setDescrizioneDelProblema(String descrizioneDelProblema) {
        this.descrizioneDelProblema = descrizioneDelProblema;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setPrenotazioniPaziente(List<Prenotazioni> prenotazioniPaziente) {
        this.prenotazioniPaziente = prenotazioniPaziente;
    }

    public Paziente(int idPaziente, String nomePaziente, String cognomePaziente, String emailPaziente,
                    String cellularePaziente, String codiceFiscalePaziente, Date dataDiNascitaPaziente,
                    String luogoDiNascitaPaziente, SessoEnum sessoPaziente, String descrizioneDelProblema,
                    Medico medico, List<Prenotazioni> prenotazioniPaziente) {
        this.idPaziente = idPaziente;
        this.nomePaziente = nomePaziente;
        this.cognomePaziente = cognomePaziente;
        this.emailPaziente = emailPaziente;
        this.cellularePaziente = cellularePaziente;
        this.codiceFiscalePaziente = codiceFiscalePaziente;
        this.dataDiNascitaPaziente = dataDiNascitaPaziente;
        this.luogoDiNascitaPaziente = luogoDiNascitaPaziente;
        this.sessoPaziente = sessoPaziente;
        this.descrizioneDelProblema = descrizioneDelProblema;
        this.medico = medico;
        this.prenotazioniPaziente = prenotazioniPaziente;
    }

    public Paziente(){}

   
}
