package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.ReglementRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ReglementMokitoTest {

    @InjectMocks
    private ReglementServiceImpl reglementService;

    @Mock
    private FactureRepository factureRepository;

    @Mock
    private ReglementRepository reglementRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void retrieveAllReglements() {

        when(reglementRepository.findAll()).thenReturn(List.of(new Reglement()));


        List<Reglement> result = reglementService.retrieveAllReglements();


        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void addReglement() {

        Reglement r = new Reglement();
        when(reglementRepository.save(r)).thenReturn(r);


        Reglement result = reglementService.addReglement(r);


        assertNotNull(result);
    }

    @Test
    void retrieveReglement() {

        Long id = 1L;
        Reglement reglement = new Reglement();
        when(reglementRepository.findById(id)).thenReturn(Optional.of(reglement));


        Reglement result = reglementService.retrieveReglement(id);


        assertNotNull(result);
    }

    @Test
    void retrieveReglementByFacture() {

        Long idFacture = 1L;
        when(reglementRepository.retrieveReglementByFacture(idFacture)).thenReturn(List.of(new Reglement()));


        List<Reglement> result = reglementService.retrieveReglementByFacture(idFacture);


        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void getChiffreAffaireEntreDeuxDate() {

        Date startDate = new Date();
        Date endDate = new Date();
        when(reglementRepository.getChiffreAffaireEntreDeuxDate(startDate, endDate)).thenReturn(100.0f);


        float result = reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);

        
        assertEquals(100.0f, result);
    }
}
