package it.studiomedico.apistudiomedico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import it.studiomedico.apistudiomedico.utilities.SessoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paziente",length = 50)
    private int idPaziente;

    @ApiModelProperty(value="The first name of the paziente ", example = "Giuseppe")
    @Column(name = "nome_paziente",length = 50)
    private String nomePaziente;

    @ApiModelProperty(value="The surname of the paziente", example = "Verdi")
    @Column(name = "cognome_paziente",length = 50)
    private String cognomePaziente;

    @ApiModelProperty(value="The paziente's email ", example = "giuseppeverdi@gmail.com")
    @Column(unique = true, name = "email_paziente",length = 100)
    private String emailPaziente;

    @ApiModelProperty(value="The contact of the paziente", example = "3334587258")
    @Column(unique = true,name = "cellulare_paziente",length = 10)
    private String cellularePaziente;

    @ApiModelProperty(value="The codice fiscale of the paziente", example = "VRDGSP24A80T987T")
    @Column(unique = true,name = "cf_paziente",length = 16)
    private String codiceFiscalePaziente;

    @ApiModelProperty(value="The date of birth of the paziente", example = "24/01/1980")
    @Column(name = "data_nascita_paziente",length = 50)
    private LocalDate dataDiNascitaPaziente;

    @ApiModelProperty(value="The place of birth of the paziente", example = "Milano")
    @Column(name = "luogo_nascita_paziente",length = 50)
    private String luogoDiNascitaPaziente;

    @ApiModelProperty(value="The sex of the paziente", example = "MASCHIO")
    @Column(name = "sesso_paziente",length = 50)
    @Enumerated(EnumType.STRING)
    private SessoEnum sessoPaziente;

    @ApiModelProperty(value="The description pf problem of the paziente", example = "Mal di pancia")
    @Column(name = "descrizione_problema",length = 250)
    private String descrizioneDelProblema;

    @ManyToOne
    private Medico medico;

    @JsonIgnore
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

    public LocalDate getDataDiNascitaPaziente() {
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

    public void setDataDiNascitaPaziente(LocalDate dataDiNascitaPaziente) {
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
                    String cellularePaziente, String codiceFiscalePaziente, LocalDate dataDiNascitaPaziente,
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
