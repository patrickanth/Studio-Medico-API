package it.studiomedico.apistudiomedico.services;


import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.entitiesDTO.MedicoDTO;
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
public class MedicoService {



    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PazienteRepository pazienteRepository;
    @Autowired
    SegretarioRepository segretarioRepository;

    @Autowired
    ModelMapper modelMapper;

    public ResponseEntity<Medico> createNewMedico(MedicoDTO medico) {
       Medico newMedico= modelMapper.map(medico, Medico.class);
        medicoRepository.saveAndFlush(newMedico);
        return new ResponseEntity<Medico>(newMedico, HttpStatus.CREATED);
    }

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> findById(Integer id) {
        return medicoRepository.findById(id);
    }

    public void deleteById(int idMedico) {
        medicoRepository.deleteById(idMedico);
    }

    public Medico getReferenceById(int idMedico, MedicoDTO medicodto) {
        Medico newMedico= modelMapper.map(medicodto, Medico.class);
        if(medicoRepository.existsById(idMedico)) {
            newMedico.setIdMedico(idMedico);


            Medico medicoToSave=medicoRepository.findById(idMedico).get();
            medicoToSave=newMedico;
            return medicoRepository.saveAndFlush(medicoToSave);
        }
        else
            return new Medico();
    }

    public void addPatient(int idMedico, int idPaziente) {

        Medico medico=medicoRepository.findById(idMedico).get();
        List<Paziente> listaPazienti=medico.getListaPazienti();
        Paziente pazienteToAdd= pazienteRepository.findById(idPaziente).get();
        pazienteToAdd.setMedico(medico);
        listaPazienti.add(pazienteToAdd);
        for (Paziente p:listaPazienti) {
            System.out.println(p.toString());
        }
    }

    public void addSegretario(int idMedico, int idSegretario) {
        Medico medico=medicoRepository.findById(idMedico).get();
        Segretario segretarioToAdd= segretarioRepository.findById(idSegretario).get();
        medico.setSegretario(segretarioToAdd);
        System.out.println(segretarioToAdd.toString());
    }
}
