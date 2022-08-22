package it.studiomedico.apistudiomedico.controllers;

import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.repository.PazienteRepository;
import it.studiomedico.apistudiomedico.repository.PrenotazioniRepository;
import it.studiomedico.apistudiomedico.repository.SegretarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerPaziente {

    @Autowired
    PazienteRepository pazienteRepository;

    @PostMapping("/aggiungiPaziente")
    public Paziente aggiungiaziente (@RequestBody Paziente paziente){
        Paziente pazienteSalvato = pazienteRepository.saveAndFlush(paziente);
        return pazienteSalvato;
    }

    @GetMapping("/listaPazienti")
    public Object listaPazienti(@RequestParam(required = false) Integer id){
        if(id == null){
            List<Paziente> pazienti = pazienteRepository.findAll();
            return pazienti;
        }
        else {
            Optional<Paziente> paziente = pazienteRepository.findById(id);
            return paziente;
        }
    }

    @PutMapping("/modificaPaziente")
    public Paziente modificaPaziente(@RequestParam(required = false) int idPaziente,
                                         @RequestBody(required = false) Segretario paziente){
        Paziente pazienteModificato = pazienteRepository.getReferenceById(idPaziente);
        return  pazienteModificato;
    }

    @DeleteMapping("/cancellaPaziente")
    public void cancellaPaziente(@RequestParam int idPaziente){
        pazienteRepository.deleteById(idPaziente);
    }
}
