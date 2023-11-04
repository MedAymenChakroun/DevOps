// package tn.esprit.rh.achat.services;
// import tn.esprit.rh.achat.entities.*;
// import tn.esprit.rh.achat.repositories.*;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.List;
// import static org.junit.Assert.*;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;
// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class ProduitServiceImplTest {
// 	 @Autowired
// 	    IProduitService produitService;
// 	    private static final Logger l = LogManager.getLogger(ProduitServiceImpl.class);
	
//     @Test
// 	public void testRetrieveAllProduit() throws ParseException {
// 		List<Produit> produit = produitService.retrieveAllProduits();
// 		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
// 		Date date11 = dateFormat.parse("30/09/2000");
// 		Date date12 = dateFormat.parse("30/09/2010");
// 		Produit sa = new Produit();
// 		sa.setCodeProduit("f-4645132");
// 		sa.setLibelleProduit("Lait");
// 		sa.setDateCreation(date11);
// 		sa.setDateDerniereModification(date12);
// 		produitService.addProduit(sa);
// 		Produit savedProduit = produitService.addProduit(sa);
// 		l.info("Produit " + sa);
// 		produitService.retrieveProduit(sa.getIdProduit());
// 		List<Produit> Produits = produitService.retrieveAllProduits();
// 		l.info("Produit " + Produits);
// 		assertNotNull(sa.getIdProduit());
// 	}
// 	@Test
// 	public void testDeleteProduit() throws ParseException {
// 		List<Produit> Produits = produitService.retrieveAllProduits();
// 		int expected = Produits.size();
// 		Produit sa = new Produit();
// 		sa.setCodeProduit("f-5156");
// 		sa.setLibelleProduit("pc");
// 		Produit savedProduit= produitService.addProduit(sa);
// 		l.info(" count" + Produits.size());
// 		produitService.deleteProduit(savedProduit.getIdProduit());
// 		l.info("size2 "+produitService.retrieveAllProduits().size());
// 		assertNull(produitService.retrieveProduit(savedProduit.getIdProduit()));
// 	}
// 	@Test
// 	public void testAddProduit() throws ParseException{
// 		List<Produit> Produits = produitService.retrieveAllProduits();
// 		Produit prod =new Produit();
// 		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
// 		Date date1 = dateFormat.parse("10/02/2020");
// 		Date date2 = dateFormat.parse("12/09/2022");
// 		prod.setCodeProduit("f-455112");
// 		prod.setLibelleProduit("Tele");
// 		prod.setDateCreation(date1);
// 		prod.setDateDerniereModification(date2);
// 		produitService.addProduit(prod);
// 		Produit savedProduit= produitService.addProduit(prod);
// 		l.info("Produit added : " + prod.getLibelleProduit());
// 		l.info("size produit : : " +Produits.size());
// 		assertNotNull(produitService.retrieveProduit(savedProduit.getIdProduit()));
// 	}
// 	@Test
// 	public void TestGetProduit(){
// 		try {
// 			Produit sa = new Produit();
// 			sa.setCodeProduit("f-515546");
// 			sa.setLibelleProduit("Telephone");
// 			Produit savedProduit= produitService.addProduit(sa);
// 			Produit prod = produitService.retrieveProduit(savedProduit.getIdProduit());
// 			l.info("Produit : " + prod.getLibelleProduit());
// 			assertNotNull(produitService.retrieveProduit(savedProduit.getIdProduit()));
// 		}catch (Exception e){
// 			l.info(e.getMessage());
// 		}
// 	}
// }
