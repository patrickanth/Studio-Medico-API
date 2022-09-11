package it.studiomedico.apistudiomedico.services;

import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.entitiesDTO.MedicoDTO;
import it.studiomedico.apistudiomedico.entitiesDTO.SegretarioDTO;
import it.studiomedico.apistudiomedico.repository.SegretarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class SegretarioService {

    @Autowired
    SegretarioRepository segretarioRepository;

    @Autowired
    ModelMapper modelMapper;

    public ResponseEntity<Segretario> creazioneSegretario(SegretarioDTO segretarioDTO){
        Segretario segretarioSalvato = modelMapper.map(segretarioDTO, Segretario.class);
        segretarioRepository.saveAndFlush(segretarioSalvato);
        return new ResponseEntity<Segretario>(segretarioSalvato, HttpStatus.CREATED);
    }

    public ResponseEntity<?> findById(int id){
        Optional<Segretario> segretarioById = segretarioRepository.findById(id);
        if (segretarioById.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(segretarioById.get(), HttpStatus.OK);
    }

    public ResponseEntity<?> findAllById(){
        List segretari = segretarioRepository.findAll();
        if (segretari.isEmpty()){
            return new ResponseEntity<>("NON C'E' NESSUN SEGRETARIO IN LISTA", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(segretari, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(int id){
        segretarioRepository.deleteById(id);
        return new ResponseEntity<>("CANCELLAZIONE EFFETUATA CON SUCCESSO", HttpStatus.OK);
    }


    public ResponseEntity<?> getReferenceById(int idSegretario, SegretarioDTO segretarioDTO) {
        Segretario newSegretario = modelMapper.map(segretarioDTO, Segretario.class);
        if(segretarioRepository.existsById(idSegretario)) {
            newSegretario.setiDSegretario(idSegretario);
            Segretario segretarioToSave = segretarioRepository.findById(idSegretario).get();
            segretarioToSave = newSegretario;
            return new ResponseEntity<>(segretarioRepository.saveAndFlush(segretarioToSave), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("ID SEGRETARIO NON TROVATO", HttpStatus.BAD_REQUEST);
    }
}
