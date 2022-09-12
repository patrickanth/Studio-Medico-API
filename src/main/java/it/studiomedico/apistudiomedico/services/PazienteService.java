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

    /**
     * @PazienteService classe dedicata ai service, in essa si trova la logica tenuta separata dalle classi Controller.
     *
     * @creaNuovoPaziente metodo per la creazione del medico nel database, il modelMapper serve a castare la classe
     * Medico a MedicoDTO.
     * @trovaTutti crea una lista di pazienti prendendo tutte le entità di questo tipo dal database
     * @trovaTramiteId con un Integer in input va a prendere un medico specifico nel database
     * @aggiornaPaziente va ad aggiornare dei campi in paziente
     * @cancellaPaziente va ad cancellare paziente
     */

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PazienteRepository pazienteRepository;

    @Autowired
    private SegretarioRepository segretarioRepository;

    //logica per quanto riguarda la gestione del CRUD

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<Paziente> creaNuovoPaziente(PazienteDTO paziente) {
        Paziente newPaziente = modelMapper.map(paziente, Paziente.class);
        pazienteRepository.saveAndFlush(newPaziente);
        return new ResponseEntity<>(newPaziente, HttpStatus.CREATED);
    }

    public List<Paziente> trovaTutti() {
        return pazienteRepository.findAll();
    }

    public Optional<Paziente> trovaTramiteId(Integer id) {
        return pazienteRepository.findById(id);
    }

    public void cancellaPaziente(int idPaziente) {
        pazienteRepository.deleteById(idPaziente);
    }

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
    } //TODO vedere se cancellare o meno questa funzione
}