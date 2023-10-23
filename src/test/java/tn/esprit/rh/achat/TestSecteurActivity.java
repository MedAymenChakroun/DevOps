package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestSecteurActivity {
    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    private SecteurActiviteServiceImpl secteurActiviteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize annotated mocks

        // Reset mock behaviors (if needed) before each test
        Mockito.reset(secteurActiviteRepository);
    }

    @Test
    public void testRetrieveAllSecteurActivite() {
        List<SecteurActivite> secteurActiviteList = new ArrayList<>();
        secteurActiviteList.add(new SecteurActivite());
        secteurActiviteList.add(new SecteurActivite());

        when(secteurActiviteRepository.findAll()).thenReturn(secteurActiviteList);

        List<SecteurActivite> result = secteurActiviteService.retrieveAllSecteurActivite();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testAddSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        when(secteurActiviteRepository.save(secteurActivite)).thenReturn(secteurActivite);

        SecteurActivite result = secteurActiviteService.addSecteurActivite(secteurActivite);

        assertNotNull(result);
    }

    @Test
    public void testDeleteSecteurActivite() {
        Long id = 1L;
        secteurActiviteService.deleteSecteurActivite(id);

        Mockito.verify(secteurActiviteRepository).deleteById(id);
    }

    @Test
    public void testUpdateSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        when(secteurActiviteRepository.save(secteurActivite)).thenReturn(secteurActivite);

        SecteurActivite result = secteurActiviteService.updateSecteurActivite(secteurActivite);

        assertNotNull(result);
    }

    @Test
    public void testRetrieveSecteurActivite() {
        Long id = 1L;
        SecteurActivite secteurActivite = new SecteurActivite();
        when(secteurActiviteRepository.findById(id)).thenReturn(Optional.of(secteurActivite));

        SecteurActivite result = secteurActiviteService.retrieveSecteurActivite(id);

        assertNotNull(result);
    }

}
