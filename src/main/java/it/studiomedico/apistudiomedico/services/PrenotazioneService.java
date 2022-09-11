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

    public ResponseEntity<Prenotazioni> creaPrenotazioni(PrenotazioniDTO prenotazione) {
        Prenotazioni prenotazioneSalvata = modelMapper.map(prenotazione, Prenotazioni.class);
        prenotazioniRepository.saveAndFlush(prenotazioneSalvata);
        return new ResponseEntity<>(prenotazioneSalvata, HttpStatus.CREATED);
    }

    public List<Prenotazioni> findAll() {
        return  prenotazioniRepository.findAll();
    }

    public Optional<Prenotazioni> trovaPrenotazione(int idPrenotazione){
            return prenotazioniRepository.findById(idPrenotazione);
    }

    public ResponseEntity<Prenotazioni> aggiornaPrenotazioni(PrenotazioniDTO prenotazione){
        Prenotazioni prenotazioneSalvata = modelMapper.map(prenotazione, Prenotazioni.class);
        prenotazioniRepository.saveAndFlush(prenotazioneSalvata);
        return new ResponseEntity<>(prenotazioneSalvata, HttpStatus.CREATED);

    }

    public void cancellaPrenotazione(int idPrenotazione) {
        prenotazioniRepository.deleteById(idPrenotazione);
    }

}
