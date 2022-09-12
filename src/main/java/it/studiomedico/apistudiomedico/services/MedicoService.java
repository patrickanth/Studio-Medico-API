package it.studiomedico.apistudiomedico.services;


import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
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
    /**
     * @MedicoService classe dedicata ai service, in essa si trova la logica tenuta separata dalle classi Controller.
     *
     * @creaNuovoMedico metodo per la creazione del medico nel database, il modelMapper serve a castare la classe
     * Medico a MedicoDTO.
     * @trovaTutti crea una lista di medici prendendo tutte le entità di questo tipo dal database
     * @trovaTramiteId con un Integer in input va a prendere un medico specifico nel database
     * @cancellaTramiteId tramite l'id viene cancellata un entità nel database
     * @addPatient va ad aggiungere un paziente ad una lista tramite l'id
     * @aggiornaMedico va ad aggiornare un medico tramite l'id ed alcuni campi con il DTO
     * @addSegretario va ad aggiungere un segretario ad una lista tramite l'id
     */

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PazienteRepository pazienteRepository;
    @Autowired
    private SegretarioRepository segretarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    //logica per quanto riguarda la gestione del CRUD

    public ResponseEntity<Medico> creaNuovoMedico(MedicoDTO medico) {
       Medico newMedico= modelMapper.map(medico, Medico.class);


        medicoRepository.saveAndFlush(newMedico);
        return new ResponseEntity<Medico>(newMedico, HttpStatus.CREATED);
    }

    public List<Medico> trovaTutti() {
        return medicoRepository.findAll();
    }

    public ResponseEntity<?> trovaTramiteId(Integer id) {
        if (medicoRepository.existsById(id)){
            return new ResponseEntity<>(medicoRepository.findById(id), HttpStatus.OK);
        }
        else  return new ResponseEntity<>("ID NON TROVATO", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> cancellaTramiteiD(int id){
        medicoRepository.deleteById(id);
        if(medicoRepository.existsById(id)){
            return new ResponseEntity<>("CANCELLAZIONE EFFETUATA CON SUCCESSO", HttpStatus.OK);
        }
        else return new ResponseEntity<>("ID SEGRETARIO NON TROVATO", HttpStatus.BAD_REQUEST);
    }

    public Medico aggiornaMedico(int idMedico, MedicoDTO medicodto) {
        Medico newMedico= modelMapper.map(medicodto, Medico.class);
        if(medicoRepository.existsById(idMedico)) {
            newMedico.setIdMedico(idMedico);


            Medico medicoToSave= medicoRepository.findById(idMedico).get();
            medicoToSave=newMedico;
            return medicoRepository.saveAndFlush(newMedico);
        }
        else
            return new Medico();
    }


    public void aggiungiPaziente(int idMedico, int idPaziente) {

        Medico medico=medicoRepository.findById(idMedico).get();
        List<Paziente> listaPazienti=medico.getListaPazienti();
        Paziente pazienteToAdd= pazienteRepository.findById(idPaziente).get();
        pazienteToAdd.setMedico(medico);
        listaPazienti.add(pazienteToAdd);
        for (Paziente p:listaPazienti) {
            System.out.println(p.toString());
        }
    }


    public void aggiungiSegretario(int idMedico, int idSegretario) {

        Medico medico=medicoRepository.findById(idMedico).get();
        Segretario segretarioToAdd= segretarioRepository.findById(idSegretario).get();
        medico.setSegretario(segretarioToAdd);
        medicoRepository.saveAndFlush(medico);
    }

    public void assegnaMedico(Medico medicoDaAssegnare) {
            medicoDaAssegnare.setListaPazienti((List<Paziente>) medicoDaAssegnare);

    } //TODO vedere se serve questo metodo
}
