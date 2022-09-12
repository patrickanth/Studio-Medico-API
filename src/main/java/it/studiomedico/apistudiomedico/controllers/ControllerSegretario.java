package it.studiomedico.apistudiomedico.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.entitiesDTO.MedicoDTO;
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

/**
 * Controller of Segretario
 *
 * all methods call the corresponding method in the SegretarioService
 */

@RestController
@RequestMapping("/segretario")
public class ControllerSegretario {

    @Autowired
    SegretarioService segretarioService;

    /**
     * creates a Segretario in db
     * @param segretarioDTO segretarioDTo to create
     * @return a ResponseEntity with just created Segretario
     */
    @ApiOperation(value="crea segretario",notes="creates a new segretario" )
    @ApiResponses({
            @ApiResponse(code=400, message = "BAD DATA INPUT"),
            @ApiResponse(code=500, message = "INTERNAL ERROR FROM SPRING", response = String.class),
            @ApiResponse(code=202, message = "Created")
    })
    @PostMapping("/aggiungi-segretario")
    public ResponseEntity<Segretario> creaNuovoSegretario(@RequestBody SegretarioDTO segretarioDTO){
        return segretarioService.creazioneSegretario(segretarioDTO);
    }


    /**
     * find a segretario in db thanks to id of segretario
     * @param id id of segretario to find
     * @return a segretario if it exixt
     */
    @ApiOperation(value = "trova segretario", notes = "return a single segretario")
    @GetMapping("/cerca-segretario/{id}")
    public ResponseEntity<?> singoloSegretario(@PathVariable int id){
        return segretarioService.trovaTramiteId(id);
    }


    /**
     * lists all segretari in db
     * @return a list of segretari
     */
    @ApiOperation(value="Lista segretari",notes="return a list of segretari in database" )
    @GetMapping("/lista-segretari")
    public ResponseEntity<?> listaSegraetari(){
        return segretarioService.trovaLista();
    }


    /**
     * Deletes a segretario from database
     * @param id id of segretario to delete
     */
    @ApiOperation(value="Cancella segretario",notes="Delete a segretario from the database" )
    @DeleteMapping("/cancella-segretario/{id}")
    public ResponseEntity<?> cancellaSegretarioTramiteiD(@PathVariable int id){
        return segretarioService.cancellaTramiteiD(id);
    }


    /**
     * updates a segretario in db
     * @param idSegretario id of segretario to update
     * @param segretarioDTO segretario dto to updates
     * @return a responseEntity with the segretario just modified
     */
    @ApiOperation(value="modifica segretario",notes="update a segretario in the database" )
    @PutMapping("/modifica-segretario")
    public ResponseEntity<?> modificaSegretario(@ApiParam(value="the id of segreatrio to chanche")@RequestParam int idSegretario,
                                 @ApiParam(value="The segretario request body")       @RequestBody SegretarioDTO segretarioDTO){
        return segretarioService.aggiornaTramiteid(idSegretario, segretarioDTO);
    }


}
