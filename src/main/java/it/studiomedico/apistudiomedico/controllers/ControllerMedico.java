package it.studiomedico.apistudiomedico.controllers;


import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.repository.MedicoRepository;
import it.studiomedico.apistudiomedico.repository.PrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerMedico {

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping("/creaMedico")
    public Medico creaMedico (@RequestBody Medico medico){
        Medico medicoSalvato = medicoRepository.saveAndFlush(medico);
        return medicoSalvato;
    }

    @GetMapping("/listaMedici")
    public Object listaMedici (@RequestParam(required = false) Integer id){
        if(id == null){
            List<Medico> medici = medicoRepository.findAll();
            return medici;
        }
        else {
            Optional<Medico> medico = medicoRepository.findById(id);
            return medico;
        }
    }

    @PutMapping("/modificaMedico")
    public Medico modificaSegretario(@RequestParam(required = false) int idMedico,
                                         @RequestBody(required = false) Medico medico){
        Medico medicoModificato = medicoRepository.getReferenceById(idMedico);
        return  medicoModificato;
    }

    @DeleteMapping("/cancellaMedico")
    public void cancellaSegretario(@RequestParam int idMedico){
        medicoRepository.deleteById(idMedico);
    }
}
