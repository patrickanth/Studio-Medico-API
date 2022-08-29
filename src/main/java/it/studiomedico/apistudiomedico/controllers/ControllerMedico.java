package it.studiomedico.apistudiomedico.controllers;


import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entitiesDTO.MedicoDTO;
import it.studiomedico.apistudiomedico.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class ControllerMedico {

    @Autowired
    MedicoService medicoService;

    @PostMapping("/crea-medico")
    public ResponseEntity<Medico> creaMedico (@RequestBody MedicoDTO medicoDTO){
        return medicoService.createNewMedico(medicoDTO);
    }

    @GetMapping("/lista-medici")
    public List<Medico> listaMedici (){

        return medicoService.findAll();
    }

    @GetMapping("/cerca-medico")
    public Optional<Medico> cercaMedico (@RequestParam Integer idMedico){

        return medicoService.findById(idMedico);


    }

   @PutMapping("/modifica-medico")
    public Medico modificaMedico(@RequestParam int idMedico,
                                         @RequestBody MedicoDTO medico){
        Medico medicoModificato = medicoService.getReferenceById(idMedico, medico);
        return  medicoModificato;
    }

    @DeleteMapping("/cancella-medico")
    public void cancellaMedico(@RequestParam int idMedico){
        medicoService.deleteById(idMedico);
    }

    @PutMapping("/aggiungi-paziente")
    public void addPatient(@RequestParam int idMedico,
                           @RequestParam int idPaziente){
        medicoService.addPatient(idMedico,idPaziente);
    }

    @PutMapping("/aggiungi-segretario")
    public void addSegretario(@RequestParam int idMedico,
                           @RequestParam int idSegretario){
        medicoService.addSegretario(idMedico,idSegretario);
    }
}
