package it.studiomedico.apistudiomedico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private int idMedico;
}
