package it.studiomedico.apistudiomedico.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    /**@ControllerPaziente
     * Controller REST
     *
     * Implementazione CRUD per gestire il database
     *
     * @creaPaziente CREATE paziente
     * @listaPazienti READ lista paziente
     * @cercaPaziente READ singolo paziente
     * @modificaPaziente UPDATE paziente
     * @cancellaPaziente DELETE paziente
     **/

    @Autowired
    PazienteRepository pazienteRepository;

    @Autowired
    PazienteService pazienteService;


    @ApiOperation(value="crea paziente ",notes="creates a new paziente" )
    @ApiResponses({
            @ApiResponse(code=400, message = "BAD DATA INPUT"),
            @ApiResponse(code=500, message = "INTERNAL ERROR FROM SPRING", response = String.class),
            @ApiResponse(code=202, message = "Created")
    })
    @PostMapping("/crea-paziente")
    public ResponseEntity<Paziente> creaPaziente (@ApiParam(value="The paziente request body") @RequestBody PazienteDTO pazienteDTO){
        return pazienteService.creaNuovoPaziente(pazienteDTO);
    }

    @ApiOperation(value="Lista pazienti",notes="return a list of pazienti in database" )
    @GetMapping("/lista-pazienti")
    public List<Paziente> listaPazienti (){

        return pazienteService.trovaTutti();
    }

    @ApiOperation(value="Cerca paziente",notes="search for a paziente in the database where it is passed as a parameter idPaziente" )
    @GetMapping("/cerca-paziente")
    public Optional<Paziente> cercaPaziente (@ApiParam(value="the idPaziente") @RequestParam Integer idPaziente){

        return pazienteService.trovaTramiteId(idPaziente);


    }


    @ApiOperation(value="modifica paziente",notes="edit a patient in the database" )
    @PutMapping("/modifica-paziente")
    public Paziente modificaPaziente(@ApiParam(value="the id of paziente to chanche")@RequestParam int idPaziente,
                                     @ApiParam(value="The paziente request body")@RequestBody PazienteDTO paziente){
        Paziente pazienteModificato = pazienteService.aggiornaPaziente(idPaziente, paziente);
        return  pazienteModificato;
    }

    @ApiOperation(value="Cancella paziente",notes="Delete a paziente from the database" )
    @DeleteMapping("/cancella-paziente")
    public void cancellaPaziente(@ApiParam(value="the id of patient to delete")@RequestParam int idPaziente){
        pazienteService.cancellaPaziente(idPaziente);
    }


}
