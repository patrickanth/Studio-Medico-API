package it.studiomedico.apistudiomedico.services;

import it.studiomedico.apistudiomedico.entities.Medico;
import it.studiomedico.apistudiomedico.entities.Paziente;
import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.entities.Segretario;
import it.studiomedico.apistudiomedico.entitiesDTO.MedicoDTO;
import it.studiomedico.apistudiomedico.entitiesDTO.PazienteDTO;
import it.studiomedico.apistudiomedico.repository.MedicoRepository;
import it.studiomedico.apistudiomedico.repository.PazienteRepository;
import it.studiomedico.apistudiomedico.repository.SegretarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@ComponentScan({"it.studiomedico.apistudiomedico.entities.Paziente"})
public class PazienteService {



    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PazienteRepository pazienteRepository;

    @Autowired
    private SegretarioRepository segretarioRepository;

    //logica per quanto riguarda la gestione del CRUD

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Creates a new Paziente and save it in db.
     *
     * @param paziente DTO for paziente to save
     * the DTO is mapped into reservations thanks to the ModelMapper
     * @return a responseEntity
     */
    public ResponseEntity<Paziente> creaNuovoPaziente(PazienteDTO paziente) {
        Paziente newPaziente = modelMapper.map(paziente, Paziente.class);
        pazienteRepository.saveAndFlush(newPaziente);
        return new ResponseEntity<>(newPaziente, HttpStatus.CREATED);
    }

    /**
     * finds all pazienti in db
     * @return a list of pazienti
     */
    public List<Paziente> trovaTutti() {
        return pazienteRepository.findAll();
    }

    /**
     * finds a paziente in db
     * @param id  of paziente to find
     * @return a paziente if it exists
     */

    public ResponseEntity<?> trovaTramiteId(Integer id) {
        Optional<Paziente> pazienteById = pazienteRepository.findById(id);
        if (pazienteById.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else
        return new ResponseEntity<>(pazienteById.get(), HttpStatus.OK);
    }
    /**
     * it deletes  a paziente
     * @param id id of paziente to delete
     */

    public ResponseEntity<?> cancellaTramiteId(int id){
        pazienteRepository.deleteById(id);
        if(pazienteRepository.existsById(id)){
            return new ResponseEntity<>("CANCELLAZIONE EFFETUATA CON SUCCESSO", HttpStatus.OK);
        }
        else return new ResponseEntity<>("ID SEGRETARIO NON TROVATO", HttpStatus.BAD_REQUEST);
    }
    /**
     * update a paziente
     * @param idPaziente DTO for paziente to updatae
     * the DTO is mapped into reservations thanks to the ModelMapper
     * @return a responseEntity
     */
    public Paziente aggiornaPaziente(int idPaziente, PazienteDTO pazienteDTO) {
        Paziente newPaziente = modelMapper.map(pazienteDTO, Paziente.class);
        if (pazienteRepository.existsById(idPaziente)) {
            newPaziente.setIdPaziente(idPaziente);
            Paziente pazienteToSave = pazienteRepository.findById(idPaziente).get();
            pazienteToSave = newPaziente;
            return pazienteRepository.saveAndFlush(newPaziente);
        } else
            return new Paziente();
    }

    public void assegnaPaziente(Paziente paziente1) {
        paziente1.setPrenotazioniPaziente((List<Prenotazioni>) paziente1);
    }
}