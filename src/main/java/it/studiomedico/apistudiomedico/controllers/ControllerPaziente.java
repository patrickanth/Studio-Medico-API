package it.studiomedico.apistudiomedico.controllers;

import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.entitiesDTO.MedicoDTO;
import it.studiomedico.apistudiomedico.entitiesDTO.PazienteDTO;
import it.studiomedico.apistudiomedico.repository.PazienteRepository;
import it.studiomedico.apistudiomedico.repository.PrenotazioniRepository;
import it.studiomedico.apistudiomedico.repository.SegretarioRepository;
import it.studiomedico.apistudiomedico.services.MedicoService;
import it.studiomedico.apistudiomedico.services.PazienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paziente")
public class ControllerPaziente {

    @Autowired
    PazienteRepository pazienteRepository;


    @Autowired
    PazienteService pazienteService;

    @PostMapping("/crea-paziente")
    public ResponseEntity<Paziente> creaPaziente (@RequestBody PazienteDTO pazienteDTO){
        return pazienteService.createNewPaziente(pazienteDTO);
    }

    @GetMapping("/lista-pazienti")
    public List<Paziente> listaPazienti (){

        return pazienteService.findAll();
    }

    @GetMapping("/cerca-paziente")
    public Optional<Paziente> cercaPaziente (@RequestParam Integer idPaziente){

        return pazienteService.findById(idPaziente);


    }

    @PutMapping("/modifica-paziente")
    public Paziente modificaPaziente(@RequestParam int idPaziente,
                                 @RequestBody PazienteDTO paziente){
        Paziente pazienteModificato = pazienteService.getReferenceById(idPaziente, paziente);
        return  pazienteModificato;
    }

    @DeleteMapping("/cancella-paziente")
    public void cancellaPaziente(@RequestParam int idPaziente){
        pazienteService.deleteById(idPaziente);
    }


}
