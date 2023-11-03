package tn.esprit.rh.achat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class TestMockito {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllStocks() {
        // Créer une liste de stocks fictifs pour le test
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("LibelleTest1", 10, 5));
        stocks.add(new Stock("LibelleTest2", 20, 8));

        // Simuler le comportement de la méthode findAll du StockRepository
        when(stockRepository.findAll()).thenReturn(stocks);

        // Appeler la méthode de récupération de tous les stocks de StockService
        List<Stock> retrievedStocks = stockService.retrieveAllStocks();

        // Vérifier que la méthode findAll du StockRepository a été appelée exactement une fois
        verify(stockRepository, times(1)).findAll();

        // Vérifier que la liste de stocks récupérés est la même que celle simulée
        assertEquals(stocks.size(), retrievedStocks.size());
    }
    @Test
    public void testAddStock() {
        // Créer un objet Stock fictif pour le test
        Stock stock = new Stock("LibelleTest", 10, 5);

        // Simuler le comportement de la méthode save du StockRepository
        when(stockRepository.save(stock)).thenReturn(stock);

        // Appeler la méthode d'ajout de stock de StockService
        Stock addedStock = stockService.addStock(stock);

        // Vérifier que la méthode save du StockRepository a été appelée exactement une fois avec le bon stock
        verify(stockRepository, times(1)).save(stock);

        // Vérifier que le stock ajouté est le même que celui renvoyé par la méthode save du StockRepository
        assertEquals(stock, addedStock);
    }
    @Test
    public void testDeleteStock() {
        // Créer un objet Stock fictif pour le test
        Stock stock = new Stock("LibelleTest", 10, 5);
        stock.setIdStock(1L);

        // Simuler le comportement de la méthode deleteById du StockRepository
        doNothing().when(stockRepository).deleteById(stock.getIdStock());

        // Appeler la méthode de suppression de stock de StockService
        stockService.deleteStock(stock.getIdStock());

        // Vérifier que la méthode deleteById du StockRepository a été appelée exactement une fois avec le bon ID
        verify(stockRepository, times(1)).deleteById(stock.getIdStock());
    }
    @Test
    public void testUpdateStock() {
        // Créer un objet Stock fictif pour le test
        Stock stock = new Stock("LibelleTest", 10, 5);
        stock.setIdStock(1L);

        // Simuler le comportement de la méthode save du StockRepository pour la mise à jour
        when(stockRepository.save(stock)).thenReturn(stock);

        // Appeler la méthode de mise à jour de stock de StockService
        Stock updatedStock = stockService.updateStock(stock);

        // Vérifier que la méthode save du StockRepository a été appelée exactement une fois avec le bon stock
        verify(stockRepository, times(1)).save(stock);

        // Vérifier que le stock mis à jour est le même que celui renvoyé par la méthode save du StockRepository
        assertEquals(stock, updatedStock);
    }


}
