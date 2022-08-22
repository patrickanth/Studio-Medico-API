package it.studiomedico.apistudiomedico.controllers;

import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.repository.SegretarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerSegretario {

    @Autowired
    SegretarioRepository segretarioRepository;

    @PostMapping("/aggiungiSegretario")
    public Segretario creazioneSegretario(@RequestBody Segretario segretario){
        Segretario segretarioSalvato = segretarioRepository.saveAndFlush(segretario);
        return segretarioSalvato;
    }

    @GetMapping("/listaSegretari")
    public Object listaSegretari(@RequestParam(required = false) Integer id){
        if(id == null){
            List<Segretario> segretari = segretarioRepository.findAll();
            return segretari;
        }
        else {
            Optional<Segretario> segretario = segretarioRepository.findById(id);
            return segretario;
        }
    }

    @PutMapping("/modificaSegretario")
    public Segretario modificaSegretario(@RequestParam(required = false) int idSegretario,
                                         @RequestBody(required = false) Segretario segretario){
        Segretario segretarioModificato = segretarioRepository.getReferenceById(idSegretario);
        return  segretarioModificato;
    }

    @DeleteMapping("/cancellaSegretario")
    public void cancellaSegretario(@RequestParam int idSegretario){
        segretarioRepository.deleteById(idSegretario);
    }
}
