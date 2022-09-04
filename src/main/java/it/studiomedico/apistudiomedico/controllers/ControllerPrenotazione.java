package it.studiomedico.apistudiomedico.controllers;


import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.entitiesDTO.PrenotazioniDTO;
import it.studiomedico.apistudiomedico.repository.MedicoRepository;
import it.studiomedico.apistudiomedico.repository.PazienteRepository;
import it.studiomedico.apistudiomedico.repository.PrenotazioniRepository;
import it.studiomedico.apistudiomedico.services.MedicoService;
import it.studiomedico.apistudiomedico.services.PazienteService;
import it.studiomedico.apistudiomedico.services.PrenotazioneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ControllerPrenotazione {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    @Autowired
    private PazienteRepository pazienteRepository;

    @Autowired
    private PazienteService pazienteService;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoService medicoService;


    @PostMapping("/crea-prenotazione/{idPaziente}/{idMedico}")
    public ResponseEntity<Prenotazioni> addPrenotazioni(@PathVariable int idPaziente, int idMedico,
                                                        @RequestBody PrenotazioniDTO prenotazione) {
        Paziente pazienteDaAssegnare = pazienteRepository.getReferenceById(idPaziente);
        pazienteService.assegnaPaziente(pazienteDaAssegnare);
        Medico medicoDaAssegnare = medicoRepository.getReferenceById(idMedico);
        medicoService.assegnaMedico(medicoDaAssegnare);
        return prenotazioneService.creaPrenotazioni(prenotazione);
    }

    @GetMapping("/lista-prenotazioni")
    public List<Prenotazioni> listaPrenotazioni() {

        return prenotazioneService.findAll();
    }

    @PutMapping("/modifica-prenotazione")
    public Prenotazioni addPrenotazioni(@RequestParam int idPaziente, int idMedico, int idPrenotazione,
                                        @RequestBody PrenotazioniDTO prenotazione) {
        Prenotazioni prenotazioneModificata = prenotazioniRepository.getReferenceById(idPrenotazione);
        Paziente pazienteDaAssegnare = pazienteRepository.getReferenceById(idPaziente);
        pazienteService.assegnaPaziente(pazienteDaAssegnare);
        Medico medicoDaAssegnare = medicoRepository.getReferenceById(idMedico);
        medicoService.assegnaMedico(medicoDaAssegnare);
        return prenotazioniRepository.saveAndFlush(prenotazioneModificata);
    }

    @DeleteMapping("/cancella-prenotazione")
    public void cancellaPaziente(@RequestParam int idPrenotazione) {
        prenotazioneService.deleteById(idPrenotazione);
    }
}



