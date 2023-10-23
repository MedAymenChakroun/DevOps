package tn.esprit.rh.achat;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
 class TestFournisseurServiceMock {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @Mock
    private ProduitRepository produitRepository;


    @InjectMocks
    FournisseurServiceImpl fournisseurService;


    Set<Facture> factures = new HashSet<>();

    Set<SecteurActivite> secteurActivites = new HashSet<>();

   Fournisseur fournisseur1 = new Fournisseur(1L, "f1", "lib1", CategorieFournisseur.CONVENTIONNE, factures, secteurActivites, new DetailFournisseur());

   Fournisseur fournisseur2 = new Fournisseur(2L, "f2", "lib2", CategorieFournisseur.ORDINAIRE, factures, secteurActivites, new DetailFournisseur());

    @Test
     void RetrieveAllFournisseursTest() {
        //FournisseurServiceImpl fournisseurService = new FournisseurServiceImpl(fournisseurRepository, detailFournisseurRepository, produitRepository, secteurActiviteRepository);

        when(fournisseurRepository.findAll()).thenReturn(Arrays.asList(fournisseur1, fournisseur2));

        List<Fournisseur> fournisseurs = fournisseurService.retrieveAllFournisseurs();

        verify(fournisseurRepository).findAll();


    }

    @Test
     void TestRetrieveFournisseur(){

       Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur1));

       Fournisseur resultFournisseur = fournisseurService.retrieveFournisseur(fournisseur1.getIdFournisseur());


       verify(fournisseurRepository).findById(fournisseur1.getIdFournisseur());
       assertSame(fournisseur1, resultFournisseur);

    }


   @Test
    void testAddFournisseur() {
      // Arrange
      Fournisseur fournisseur = new Fournisseur();
      DetailFournisseur detailFournisseur = new DetailFournisseur();
      when(detailFournisseurRepository.save(any())).thenReturn(detailFournisseur);


      Fournisseur resultFournisseur = fournisseurService.addFournisseur(fournisseur);


      verify(detailFournisseurRepository).save(any());
      verify(fournisseurRepository).save(fournisseur);
      assertSame(detailFournisseur, resultFournisseur.getDetailFournisseur());
   }

   @Test
    void testUpdateFournisseur() {
      // Arrange

      DetailFournisseur detailFournisseur = new DetailFournisseur();
      fournisseur1.setDetailFournisseur(detailFournisseur);
      when(detailFournisseurRepository.save(any())).thenReturn(detailFournisseur);


      Fournisseur resultFournisseur = fournisseurService.updateFournisseur(fournisseur1);


      verify(detailFournisseurRepository).save(any());
      verify(fournisseurRepository).save(fournisseur1);
      assertSame(detailFournisseur, resultFournisseur.getDetailFournisseur());
   }


   @Test
    void testDeleteFournisseur() {

      fournisseurService.deleteFournisseur(fournisseur2.getIdFournisseur());


      verify(fournisseurRepository).deleteById(fournisseur2.getIdFournisseur());
   }

   @Test
    void testAssignSecteurActiviteToFournisseur() {

      //Long idSecteurActivite = 1L;

      SecteurActivite secteurActivite = new SecteurActivite();
      when(fournisseurRepository.findById(fournisseur1.getIdFournisseur())).thenReturn(Optional.of(fournisseur1));
      when(secteurActiviteRepository.findById(secteurActivite.getIdSecteurActivite())).thenReturn(Optional.of(secteurActivite));


      fournisseurService.assignSecteurActiviteToFournisseur(secteurActivite.getIdSecteurActivite(), fournisseur1.getIdFournisseur());


      verify(fournisseurRepository).findById(fournisseur1.getIdFournisseur());
      verify(secteurActiviteRepository).findById(secteurActivite.getIdSecteurActivite());
      assertTrue(fournisseur1.getSecteurActivites().contains(secteurActivite));
   }





}