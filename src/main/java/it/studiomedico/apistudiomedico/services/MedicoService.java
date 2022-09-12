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


    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PazienteRepository pazienteRepository;
    @Autowired
    private SegretarioRepository segretarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    //logica per quanto riguarda la gestione del CRUD

    /**
     * Creates a new Medico and save it in db.
     *
     * @param medico DTO for medico to save
     *               the DTO is mapped into reservations thanks to the ModelMapper
     * @return a responseEntity
     */
    public ResponseEntity<Medico> creaNuovoMedico(MedicoDTO medico) {
        Medico newMedico = modelMapper.map(medico, Medico.class);


        medicoRepository.saveAndFlush(newMedico);
        return new ResponseEntity<Medico>(newMedico, HttpStatus.CREATED);
    }

    /**
     * finds all medico in db
     *
     * @return a list of medico
     */
    public List<Medico> trovaTutti() {
        return medicoRepository.findAll();
    }

    /**
     * finds a medico in db thanks to id
     *
     * @param id of medico to find
     * @return a medico if it exists
     */
    public ResponseEntity<?> trovaTramiteId(Integer id) {
        if (medicoRepository.existsById(id)) {
            return new ResponseEntity<>(medicoRepository.findById(id), HttpStatus.OK);
        } else return new ResponseEntity<>("ID NON TROVATO", HttpStatus.BAD_REQUEST);
    }

    /**
     * it deletes  a medico
     *
     * @param id id of medico to delete
     */
    public ResponseEntity<?> cancellaTramiteiD(int id) {
        medicoRepository.deleteById(id);
        if (medicoRepository.existsById(id)) {
            return new ResponseEntity<>("CANCELLAZIONE EFFETUATA CON SUCCESSO", HttpStatus.OK);
        } else return new ResponseEntity<>("ID SEGRETARIO NON TROVATO", HttpStatus.BAD_REQUEST);
    }

    /**
     * update a Medico
     *
     * @param medicodto DTO for prenotazioni to updatae
     *                  the DTO is mapped into reservations thanks to the ModelMapper
     * @return a responseEntity
     */
    public Medico aggiornaMedico(int idMedico, MedicoDTO medicodto) {
        Medico newMedico = modelMapper.map(medicodto, Medico.class);
        if (medicoRepository.existsById(idMedico)) {
            newMedico.setIdMedico(idMedico);


            Medico medicoToSave = medicoRepository.findById(idMedico).get();
            medicoToSave = newMedico;
            return medicoRepository.saveAndFlush(newMedico);
        } else
            return new Medico();
    }


    public void aggiungiPaziente(int idMedico, int idPaziente) {

        Medico medico = medicoRepository.findById(idMedico).get();
        List<Paziente> listaPazienti = medico.getListaPazienti();
        Paziente pazienteToAdd = pazienteRepository.findById(idPaziente).get();
        pazienteToAdd.setMedico(medico);
        listaPazienti.add(pazienteToAdd);
        for (Paziente p : listaPazienti) {
            System.out.println(p.toString());
        }
    }


    public void aggiungiSegretario(int idMedico, int idSegretario) {

        Medico medico = medicoRepository.findById(idMedico).get();
        Segretario segretarioToAdd = segretarioRepository.findById(idSegretario).get();
        medico.setSegretario(segretarioToAdd);
        medicoRepository.saveAndFlush(medico);
    }

    public void assegnaMedico(Medico medicoDaAssegnare) {
        medicoDaAssegnare.setListaPazienti((List<Paziente>) medicoDaAssegnare);


    }
}