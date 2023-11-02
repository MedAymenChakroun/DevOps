package tn.esprit.rh.achat.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.repositories.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestMockito {

    @Mock
    private ProduitRepository produitRepository;

    @Mock
    private StockRepository stockRepository;

    @Mock
    private CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    private ProduitServiceImpl produitService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllProduits() {
        List<Produit> produits = new ArrayList<>();
        produits.add(new Produit());
        produits.add(new Produit());
        when(produitRepository.findAll()).thenReturn(produits);

        List<Produit> retrievedProduits = produitService.retrieveAllProduits();

        assertEquals(produits.size(), retrievedProduits.size());
        verify(produitRepository, times(1)).findAll();
    }

    @Test
    public void testAddProduit() {
        Produit produit = new Produit();
        when(produitRepository.save(produit)).thenReturn(produit);

        Produit addedProduit = produitService.addProduit(produit);

        assertEquals(produit, addedProduit);
        verify(produitRepository, times(1)).save(produit);
    }

    @Test
    public void testDeleteProduit() {
        Long produitId = 1L;

        produitService.deleteProduit(produitId);

        verify(produitRepository, times(1)).deleteById(produitId);
    }

    @Test
    public void testUpdateProduit() {
        Produit produit = new Produit();
        when(produitRepository.save(produit)).thenReturn(produit);

        Produit updatedProduit = produitService.updateProduit(produit);

        assertEquals(produit, updatedProduit);
        verify(produitRepository, times(1)).save(produit);
    }

    @Test
    public void testRetrieveProduit() {
        Long produitId = 1L;
        Produit produit = new Produit();
        when(produitRepository.findById(produitId)).thenReturn(java.util.Optional.of(produit));

        Produit retrievedProduit = produitService.retrieveProduit(produitId);

        assertEquals(produit, retrievedProduit);
        verify(produitRepository, times(1)).findById(produitId);
    }

    @Test
    public void testAssignProduitToStock() {
        Long idProduit = 1L;
        Long idStock = 2L;
        Produit produit = new Produit();
        Stock stock = new Stock();
        when(produitRepository.findById(idProduit)).thenReturn(java.util.Optional.of(produit));
        when(stockRepository.findById(idStock)).thenReturn(java.util.Optional.of(stock));
        when(produitRepository.save(produit)).thenReturn(produit);

        produitService.assignProduitToStock(idProduit, idStock);

        assertEquals(stock, produit.getStock());
        verify(produitRepository, times(1)).findById(idProduit);
        verify(stockRepository, times(1)).findById(idStock);
        verify(produitRepository, times(1)).save(produit);
    }
}