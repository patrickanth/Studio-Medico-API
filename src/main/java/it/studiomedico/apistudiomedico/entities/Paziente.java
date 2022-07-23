package it.studiomedico.apistudiomedico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Paziente ")
public class Paziente {

    @Id
    private int idPaziente;
    private String name;
    private String surname;
    @Column(unique = true, name = "emailPaziente",length = 100)
    private String email;

    @ManyToOne
    private Medico medico;

    @OneToMany(mappedBy = "idPaziente")
    private List<Prenotazioni> prenotazioni;

}
