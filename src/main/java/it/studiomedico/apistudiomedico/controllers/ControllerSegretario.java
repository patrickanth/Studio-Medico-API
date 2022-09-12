package it.studiomedico.apistudiomedico.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

@RestController
@RequestMapping("/segretario")
public class ControllerSegretario {

    @Autowired
    SegretarioService segretarioService;

    @PostMapping("/aggiungi-segretario")
    public ResponseEntity<Segretario> creaNuovoSegretario(@RequestBody SegretarioDTO segretarioDTO){
        return segretarioService.creazioneSegretario(segretarioDTO);
    }

    @GetMapping("/cerca-segretario/{id}")
    public ResponseEntity<?> singoloSegretario(@PathVariable int id){
        return segretarioService.trovaTramiteId(id);
    }

    @GetMapping("/lista-segretari")
    public ResponseEntity<?> listaSegraetari(){
        return segretarioService.trovaLista();
    }


    @DeleteMapping("/cancella-segretario/{id}")
    public ResponseEntity<?> cancellaSegretarioTramiteiD(@PathVariable int id){
        return segretarioService.cancellaTramiteiD(id);
    }



    @ApiOperation(value="modifica segretario",notes="edit a segretario in the database" )
    @PutMapping("/modifica-segretario")
    public ResponseEntity<?> modificaSegretario(@ApiParam(value="the id of segreatrio to chanche")@RequestParam int idSegretario,
                                 @ApiParam(value="The segretario request body")       @RequestBody SegretarioDTO segretarioDTO){
        return segretarioService.aggiornaTramiteid(idSegretario, segretarioDTO);
    }


}
