package it.studiomedico.apistudiomedico.controllers;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.entitiesDTO.PrenotazioniDTO;
import it.studiomedico.apistudiomedico.repository.MedicoRepository;
import it.studiomedico.apistudiomedico.repository.PazienteRepository;
import it.studiomedico.apistudiomedico.repository.PrenotazioniRepository;
import it.studiomedico.apistudiomedico.services.MedicoService;
import it.studiomedico.apistudiomedico.services.PazienteService;
import it.studiomedico.apistudiomedico.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @ApiOperation(value="crea prenotazione",notes="creates a new booking" )
    @ApiResponses({
            @ApiResponse(code=400, message = "BAD DATA INPUT"),
            @ApiResponse(code=500, message = "INTERNAL ERROR FROM SPRING", response = String.class),
            @ApiResponse(code=202, message = "Created")
    })

    @PostMapping("/crea-prenotazione/{idPaziente}/{idMedico}")
    public ResponseEntity<Prenotazioni> creaPrenotazioni(@ApiParam(value="The idPaziente of prenotazione")@PathVariable int idPaziente,
                                                        @ApiParam(value="The idMedico of prenotazione")@PathVariable int idMedico,
                                                        @ApiParam(value="The prenototazione request body")@RequestBody PrenotazioniDTO prenotazione) {
        if(pazienteRepository.existsById(idPaziente) & medicoRepository.existsById(idMedico)){
            prenotazione.setDataPrenotazione(prenotazione.getDataPrenotazione());
            prenotazione.setSedeVisita(prenotazione.getSedeVisita());
            prenotazione.setIdMedico(idMedico);
            prenotazione.setIdPaziente(idPaziente);
            prenotazione.setStatoPrenotazione(prenotazione.getStatoPrenotazione());
            return prenotazioneService.creaPrenotazioni(prenotazione);
        }
        else
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value="Lista prenotazione",notes="return a list of bookings in database" )
    @GetMapping("/lista-prenotazioni")
    public List<Prenotazioni> listaPrenotazioni() {

        return prenotazioneService.findAll();
    }
    @ApiOperation(value = "trova prenotazione", notes = "return a single existing booking")
    @GetMapping("trova-Prenotazione")
    public Optional<Prenotazioni> trovaSingolaPrenotazione(@ApiParam(value = "The idPrenotazione of prenotazione")
                                                               @RequestParam int idPrenotazione){
        return prenotazioneService.trovaPrenotazione(idPrenotazione);
    }

    @ApiOperation(value="modifica prenotazione",notes="edit a prenotazione  in the database" )
    @PutMapping("/modifica-prenotazione")
    public ResponseEntity<Prenotazioni> aggiornaPrenotazioni(@ApiParam(value="The idPaziente of prenotazione")@RequestParam int idPaziente,
                                        @ApiParam(value="The idMedico of prenotazione")@RequestParam int idMedico,
                                        @ApiParam(value="The idPrenotazione of prenotazione")@RequestParam int idPrenotazione,
                                        @ApiParam(value="The prenototazione request body")@RequestBody PrenotazioniDTO prenotazione) {
        if (pazienteRepository.existsById(idPaziente) & medicoRepository.existsById(idMedico) && prenotazioniRepository.existsById(idPrenotazione)) {
            prenotazione.setDataPrenotazione(prenotazione.getDataPrenotazione());
            prenotazione.setSedeVisita(prenotazione.getSedeVisita());
            prenotazione.setIdMedico(idMedico);
            prenotazione.setIdPaziente(idPaziente);
            prenotazione.setStatoPrenotazione(prenotazione.getStatoPrenotazione());
            return prenotazioneService.aggiornaPrenotazioni(prenotazione);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value="Cancella prenotazione",notes="Delete a booking from the database" )
    @DeleteMapping("/cancella-prenotazione")
    public void cancellaPrenotazione(@ApiParam(value="The idPrenotazione of prenotazione")@RequestParam int idPrenotazione) {
        prenotazioneService.cancellaPrenotazione(idPrenotazione);
    }
}



