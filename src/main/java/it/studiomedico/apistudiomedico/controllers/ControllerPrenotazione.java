package it.studiomedico.apistudiomedico.controllers;


import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.repository.MedicoRepository;
import it.studiomedico.apistudiomedico.repository.PazienteRepository;
import it.studiomedico.apistudiomedico.repository.PrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController()
public class ControllerPrenotazione {

    @Autowired
    PrenotazioniRepository prenotazioniRepository;

    @Autowired
    PazienteRepository pazienteRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping("/creaPrenotazione")
    public Prenotazioni addPrenotazioni(@RequestBody int idPaziente, int idMedico, Prenotazioni prenotazione) {
        Optional<Paziente> paziente = pazienteRepository.findById(idPaziente);
        Optional<Medico> medico = medicoRepository.findById(idMedico);
        if (paziente.isPresent() && medico.isPresent()) {
            Prenotazioni prenotazioneSalvata = prenotazioniRepository.saveAndFlush(prenotazione);
            prenotazione.setMedico(medico.get());
            prenotazioneSalvata.setPaziente(paziente.get());
            return prenotazioneSalvata;
        }
        else return prenotazione;
    }

}



