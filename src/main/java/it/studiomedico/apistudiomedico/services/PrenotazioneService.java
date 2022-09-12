package it.studiomedico.apistudiomedico.services;

import it.studiomedico.apistudiomedico.entities.Prenotazioni;
import it.studiomedico.apistudiomedico.entitiesDTO.PrenotazioniDTO;
import it.studiomedico.apistudiomedico.repository.MedicoRepository;
import it.studiomedico.apistudiomedico.repository.PazienteRepository;
import it.studiomedico.apistudiomedico.repository.PrenotazioniRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class implements a service for Prenotazione.
 */

@Service
public class PrenotazioneService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PazienteService pazienteService;
    @Autowired
    PazienteRepository pazienteRepository;
    @Autowired
    MedicoService medicoService;
    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    /**
     * Creates a new Prenotazioni and save it in db.
     *
     * @param prenotazione DTO for prenotazioni to save
     * the DTO is mapped into reservations thanks to the ModelMapper
     * @return a responseEntity
     */

    public ResponseEntity<Prenotazioni> creaPrenotazioni(PrenotazioniDTO prenotazione) {
        Prenotazioni prenotazioneSalvata = modelMapper.map(prenotazione, Prenotazioni.class);
        prenotazioniRepository.saveAndFlush(prenotazioneSalvata);
        return new ResponseEntity<>(prenotazioneSalvata, HttpStatus.CREATED);
    }

    /**
     * finds all prenotazioni in db
     * @return a list of prenotazioni
     */

    public List<Prenotazioni> findAll() {
        return  prenotazioniRepository.findAll();
    }

    /**
     * finds a prenotazione in db thanks to idPrenotazione
     * @param idPrenotazione id of prenotazione to find
     * @return a prenotazione if it exists
     */

    public Optional<Prenotazioni> trovaPrenotazione(int idPrenotazione){
            return prenotazioniRepository.findById(idPrenotazione);
    }

    /**
     * update a prenotazione
     * @param prenotazione DTO for prenotazioni to updatae
     * the DTO is mapped into reservations thanks to the ModelMapper
     * @return a responseEntity
     */

    public ResponseEntity<Prenotazioni> aggiornaPrenotazioni(PrenotazioniDTO prenotazione){
        Prenotazioni prenotazioneSalvata = modelMapper.map(prenotazione, Prenotazioni.class);
        prenotazioniRepository.saveAndFlush(prenotazioneSalvata);
        return new ResponseEntity<>(prenotazioneSalvata, HttpStatus.CREATED);

    }

    /**
     * it deletes  a prenotazione
     * @param idPrenotazione id of prenotazione to delete
     */

    public void cancellaPrenotazione(int idPrenotazione) {
        prenotazioniRepository.deleteById(idPrenotazione);
    }

}
