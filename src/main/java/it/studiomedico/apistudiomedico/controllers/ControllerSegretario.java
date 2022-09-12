package it.studiomedico.apistudiomedico.controllers;

import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.entitiesDTO.SegretarioDTO;
import it.studiomedico.apistudiomedico.repository.MedicoRepository;
import it.studiomedico.apistudiomedico.repository.SegretarioRepository;
import it.studiomedico.apistudiomedico.services.SegretarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/segretario")
public class ControllerSegretario {

    @Autowired
    SegretarioService segretarioService;

    @PostMapping("/aggiungi-segretario")
    public ResponseEntity<Segretario> postSegretario(@RequestBody SegretarioDTO segretarioDTO){
        return segretarioService.creazioneSegretario(segretarioDTO);
    }

    @GetMapping("/cerca-segretario/{id}")
    public ResponseEntity<?> getSegretario(@PathVariable int id){
        return segretarioService.findById(id);
    }

    @GetMapping("/lista-segretari")
    public ResponseEntity<?> getListaSegraetari(){
        return segretarioService.findAllById();
    }


    @DeleteMapping("/cancella-segretario/{id}")
    public ResponseEntity<?> deleteSegretario(@PathVariable int id){
        return segretarioService.deleteById(id);
    }



}
