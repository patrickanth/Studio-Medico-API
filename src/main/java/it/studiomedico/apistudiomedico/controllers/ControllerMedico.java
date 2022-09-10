package it.studiomedico.apistudiomedico.controllers;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value="Create medico",notes="creates a new medico" )
    @ApiResponses({
            @ApiResponse(code=400, message = "BAD DATA INPUT"),
            @ApiResponse(code=500, message = "INTERNAL ERROR FROM SPRING", response = String.class),
            @ApiResponse(code=202, message = "Created")
    })
    @PostMapping("/crea-medico")
    public ResponseEntity<Medico> creaMedico (@ApiParam(value="The medico request body") @RequestBody MedicoDTO medicoDTO){
        return medicoService.createNewMedico(medicoDTO);
    }

    @ApiOperation(value="Lista medici",notes="return a list of medici in database" )
    @GetMapping("/lista-medici")
    public List<Medico> listaMedici (){

        return medicoService.findAll();
    }

    @ApiOperation(value="Cerca medico",notes="search for a doctor in the database where it is passed as a parameter idMedico" )
    @GetMapping("/cerca-medico")
    public Optional<Medico> cercaMedico (@ApiParam(value="the idMedico ") @RequestParam Integer idMedico){

        return medicoService.findById(idMedico);


    }


    @ApiOperation(value="modifica medico",notes="edit a doctor in the database" )
   @PutMapping("/modifica-medico")
    public Medico modificaMedico(@ApiParam(value="the id of medico to chanche")@RequestParam int idMedico,
                                  @ApiParam(value="The medico request body")       @RequestBody MedicoDTO medico){
        Medico medicoModificato = medicoService.getReferenceById(idMedico, medico);
        return  medicoModificato;
    }

    @ApiOperation(value="Cancella medico",notes="Delete a doctor from the database" )
    @DeleteMapping("/cancella-medico")
    public void cancellaMedico(@ApiParam(value="the id of medico to delete") @RequestParam int idMedico){
        medicoService.deleteById(idMedico);
    }

    @ApiOperation(value="Aggiungi paziente",notes="Add a patient in the list of patient of a doctor in the database" )
    @PutMapping("/aggiungi-paziente")
    public void addPatient(@ApiParam(value="the id of medico")@RequestParam int idMedico,
                           @ApiParam(value="the id of patient to add")@RequestParam int idPaziente){
        medicoService.addPatient(idMedico,idPaziente);
    }
    @ApiOperation(value="Aggiungi paziente",notes="Add a segretario for a doctor in the database" )
    @PutMapping("/aggiungi-segretario")
    public void addSegretario(@ApiParam(value="the id of medico") @RequestParam int idMedico,
                              @ApiParam(value="the id of segretario")@RequestParam int idSegretario){
        medicoService.addSegretario(idMedico,idSegretario);
    }
}
