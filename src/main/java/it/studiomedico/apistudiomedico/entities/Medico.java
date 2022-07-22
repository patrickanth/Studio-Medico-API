package it.studiomedico.apistudiomedico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Medico")
public class Medico {

    @Id
    private int idMedico;
    private String name;
    private String surname;
    @Column(unique = true, name = "emailMedico",length = 100)
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    private int idSegretario;

}
