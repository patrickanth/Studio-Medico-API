package it.studiomedico.apistudiomedico.entities;

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
    @Column(name = "iDSegretario",length = 50)
    private int iDSegretario;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nomeSegretario",length = 50)
    private String nomeSegretario;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cognomeSegretario",length = 50)
    private String cognomeSegretario;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "emailSegretario",length = 100)
    private String emailSegretario;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,name = "contattoUfficioSegretario",length = 30)
    private int contattoUfficioSegretario;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sedeDiLavoro",length = 100)
    private String sedeDiLavoro;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "giorniLavorativi",length = 100)
    private String giorniLavorativi;


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

    public int getContattoUfficioSegretario() {
        return contattoUfficioSegretario;
    }

    public void setContattoUfficioSegretario(int contattoUfficioSegretario) {
        this.contattoUfficioSegretario = contattoUfficioSegretario;
    }

    public String getSedeDiLavoro() {
        return sedeDiLavoro;
    }

    public void setSedeDiLavoro(String sedeDiLavoro) {
        this.sedeDiLavoro = sedeDiLavoro;
    }

    public String getGiorniLavorativi() {
        return giorniLavorativi;
    }

    public void setGiorniLavorativi(String giorniLavorativi) {
        this.giorniLavorativi = giorniLavorativi;
    }

    public List<Medico> getListaMedici() {
        return listaMedici;
    }

    public void setListaMedici(List<Medico> listaMedici) {
        this.listaMedici = listaMedici;
    }

    public Segretario(int iDSegretario, String nomeSegretario, String cognomeSegretario, String emailSegretario,
                      int contattoUfficioSegretario, String sedeDiLavoro, String giorniLavorativi,
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
