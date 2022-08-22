package it.studiomedico.apistudiomedico.controllers;


import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.repository.PrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.OptionalInt;


@RestController()
public class ControllerPrenotazione {

    @Autowired
    PrenotazioniRepository prenotazioniRepository;

    @PostMapping("/creaPrenotazione")
    public Prenotazioni addPrenotazioni (@RequestBody int idPaziente, int idMedico, Prenotazioni prenotazione){
        Prenotazioni prenotazioneSalvata = prenotazioniRepository.saveAndFlush(prenotazione);
        return prenotazioneSalvata;

    }


}
