package it.studiomedico.apistudiomedico.entities;

import io.swagger.annotations.ApiModelProperty;
import it.studiomedico.apistudiomedico.utilities.GiorniLavorativiEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Column(name = "id_medico",length = 100)
    private int idMedico;

    @ApiModelProperty(value="The first name of the medico", example = "Giuseppe")
    @Column(name = "nome_medico",length = 50)
    private String nomeMedico;

    @ApiModelProperty(value="The surname of the medico", example = "Verdi")
    @Column(name = "cognome_medico",length = 50)
    private String cognomeMedico;

    @ApiModelProperty(value="The specialization of the medico", example ="general surgery")
    @Column(name = "specializzazione",length = 50)
    private String specializzazione;


    @ApiModelProperty(value="The medico's email ", example = "giuseppeverdi@gmail.com")
    @Column(unique = true, name = "email_medico",length = 100)
    private String emailMedico;

    @ApiModelProperty(value="The office contact of the medico", example = "3334587258")
    @Column(unique = true,name = "contatto_ufficio_medico",length = 10)
    private String contattoUfficioMedico;

    @ApiModelProperty(value="The workplace of the medico", example = "via Garibaldi, 16")
    @Column(name = "sede_lavoro",length = 50)
    private String sedeDiLavoro;

    @ApiModelProperty(value="The working days of the medico", example = "LUNEDI")
    @Column(name = "giorni_lavorativi",length = 50)
    @Enumerated(EnumType.STRING)
    private GiorniLavorativiEnum giorniLavorativi;

    @ManyToOne
    @JoinColumn(name = "id_segretario", foreignKey = @ForeignKey(name = "id_segretario"))
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
