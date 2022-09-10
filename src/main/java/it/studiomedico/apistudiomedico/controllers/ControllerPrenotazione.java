package it.studiomedico.apistudiomedico.controllers;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/prenotazione")
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


    @ApiOperation(value="crea prenotazione",notes="creates a new prenotazione" )
    @ApiResponses({
            @ApiResponse(code=400, message = "BAD DATA INPUT"),
            @ApiResponse(code=500, message = "INTERNAL ERROR FROM SPRING", response = String.class),
            @ApiResponse(code=202, message = "Created")
    })
    @PostMapping("/crea-prenotazione/{idPaziente}/{idMedico}")
    public ResponseEntity<Prenotazioni> addPrenotazioni(@ApiParam(value="The idPaziente of prenotazione")@PathVariable int idPaziente,
                                                        @ApiParam(value="The idMedico of prenotazione")@PathVariable int idMedico,
                                                        @ApiParam(value="The prenototazione request body")@RequestBody PrenotazioniDTO prenotazione) {
        Paziente pazienteDaAssegnare = pazienteRepository.getReferenceById(idPaziente);
        pazienteService.assegnaPaziente(pazienteDaAssegnare);
        Medico medicoDaAssegnare = medicoRepository.getReferenceById(idMedico);
        medicoService.assegnaMedico(medicoDaAssegnare);
        return prenotazioneService.creaPrenotazioni(prenotazione);
    }

    @ApiOperation(value="Lista prenotazione",notes="return a list of prenotazioni in database" )
    @GetMapping("/lista-prenotazioni")
    public List<Prenotazioni> listaPrenotazioni() {

        return prenotazioneService.findAll();
    }

    @ApiOperation(value="modifica prenotazione",notes="edit a prenotazione  in the database" )
    @PutMapping("/modifica-prenotazione")
    public Prenotazioni addPrenotazioni(@ApiParam(value="The idPaziente of prenotazione")@RequestParam int idPaziente,
                                        @ApiParam(value="The idMedico of prenotazione")@RequestParam int idMedico,
                                        @ApiParam(value="The idPrenotazione of prenotazione")@RequestParam int idPrenotazione,
                                        @ApiParam(value="The prenototazione request body")@RequestBody PrenotazioniDTO prenotazione) {
        Prenotazioni prenotazioneModificata = prenotazioniRepository.getReferenceById(idPrenotazione);
        Paziente pazienteDaAssegnare = pazienteRepository.getReferenceById(idPaziente);
        pazienteService.assegnaPaziente(pazienteDaAssegnare);
        Medico medicoDaAssegnare = medicoRepository.getReferenceById(idMedico);
        medicoService.assegnaMedico(medicoDaAssegnare);
        return prenotazioniRepository.saveAndFlush(prenotazioneModificata);
    }

    @ApiOperation(value="Cancella prenotazione",notes="Delete a prenotazione from the database" )
    @DeleteMapping("/cancella-prenotazione")
    public void cancellaPaziente(@ApiParam(value="The idPrenotazione of prenotazione")@RequestParam int idPrenotazione) {
        prenotazioneService.deleteById(idPrenotazione);
    }
}



