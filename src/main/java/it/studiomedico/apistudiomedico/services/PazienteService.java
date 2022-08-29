package it.studiomedico.apistudiomedico.services;

import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.entitiesDTO.MedicoDTO;
import it.studiomedico.apistudiomedico.entitiesDTO.PazienteDTO;
import it.studiomedico.apistudiomedico.repository.MedicoRepository;
import it.studiomedico.apistudiomedico.repository.PazienteRepository;
import it.studiomedico.apistudiomedico.repository.SegretarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PazienteService {


    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    PazienteRepository pazienteRepository;
    @Autowired
    SegretarioRepository segretarioRepository;

    @Autowired
    ModelMapper modelMapper;

    public ResponseEntity<Paziente> createNewPaziente(PazienteDTO paziente) {
        Paziente newPaziente = modelMapper.map(paziente, Paziente.class);
        pazienteRepository.saveAndFlush(newPaziente);
        return new ResponseEntity<Paziente>(newPaziente, HttpStatus.CREATED);
    }

    public List<Paziente> findAll() {
        return pazienteRepository.findAll();
    }

    public Optional<Paziente> findById(Integer id) {
        return pazienteRepository.findById(id);
    }

    public void deleteById(int idPaziente) {
        pazienteRepository.deleteById(idPaziente);
    }

    public Paziente getReferenceById(int idPaziente, PazienteDTO pazienteDTO) {
        Paziente newPaziente= modelMapper.map(pazienteDTO, Paziente.class);
        if(pazienteRepository.existsById(idPaziente)) {
            newPaziente.setIdPaziente(idPaziente);


            Paziente pazienteToSave=pazienteRepository.findById(idPaziente).get();
            pazienteToSave=newPaziente;
            return pazienteRepository.saveAndFlush(pazienteToSave);
        }
        else
            return new Paziente();
    }

}
