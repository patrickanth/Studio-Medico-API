package it.studiomedico.apistudiomedico.repository;

import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PrenotazioniRepository extends JpaRepository<Prenotazioni,Integer> {
}
