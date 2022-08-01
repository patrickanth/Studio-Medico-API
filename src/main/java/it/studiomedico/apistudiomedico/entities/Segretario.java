package it.studiomedico.apistudiomedico.entities;

import it.studiomedico.apistudiomedico.utilities.GiorniLavorativiEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "segretario")
public class Segretario {


    /**@Segretario Questa è la tabella riguardante il complesso "segretari", i segretari in carico devono lasciare
     *le generalità con i corrispettivi parametri:
     *
     * @iDSegretario
     * @nomeSegretario
     * @cognomeSegretario
     * @emailSegretario
     * @contattoUfficioSegretario
     * @sedeDiLavoro
     * @giorniLavorativi
     *
     * @listaMedici Il segretario in questione avrà in carico dei medici da assegnare ai pazienti, questa lista ne
     * terrà traccia.
     **/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_segretario",length = 50)
    private int iDSegretario;


    @Column(name = "nome_segretario",length = 50)
    private String nomeSegretario;


    @Column(name = "cognome_segretario",length = 50)
    private String cognomeSegretario;


    @Column(unique = true, name = "email_segretario",length = 100)
    private String emailSegretario;


    @Column(unique = true,name = "contatto_ufficio_segretario",length = 10)
    private String contattoUfficioSegretario;


    @Column(name = "sede_lavoro",length = 100)
    private String sedeDiLavoro;


    @Column(name = "giorni_lavorativi",length = 100)
    private GiorniLavorativiEnum giorniLavorativi;


    @OneToMany(mappedBy ="segretario")
    private List<Medico> listaMedici;


    public int getiDSegretario() {
        return iDSegretario;
    }

    public void setiDSegretario(int iDSegretario) {
        this.iDSegretario = iDSegretario;
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

    public List<Medico> getListaMedici() {
        return listaMedici;
    }


    public void setListaMedici(List<Medico> listaMedici) {
        this.listaMedici = listaMedici;
    }

    public Segretario(int iDSegretario, String nomeSegretario, String cognomeSegretario, String emailSegretario,
                      String contattoUfficioSegretario, String sedeDiLavoro, GiorniLavorativiEnum giorniLavorativi,
                      List<Medico> listaMedici) {
        this.iDSegretario = iDSegretario;
        this.nomeSegretario = nomeSegretario;
        this.cognomeSegretario = cognomeSegretario;
        this.emailSegretario = emailSegretario;
        this.contattoUfficioSegretario = contattoUfficioSegretario;
        this.sedeDiLavoro = sedeDiLavoro;
        this.giorniLavorativi = giorniLavorativi;
        this.listaMedici = listaMedici;
    }

    public Segretario(){}

   
}
