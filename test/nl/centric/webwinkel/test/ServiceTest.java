package nl.centric.webwinkel.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nl.centric.webwinkel.model.Artikel;
import nl.centric.webwinkel.service.ArtikelService;

public class ServiceTest {

	private ArtikelService service;

	@Before
	public void init() {
		service = new ArtikelService();
	}

	@Test
	public void testAddArtikel() {
		service.addArtikel(maakArtikel("sporthoed"));
	}

	@Test
	public void testGetArtikel() {
		try {
			Artikel a = service.getArtikel(1);
			assertTrue(a.getNaam().equals("sportschoen"));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGetArtikelen() {
		try {
			List<Artikel> list = service.getArtikelen();
			assertTrue(list.size() > 1);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testUpdateArtikel() {
		try {
			Artikel a = service.getArtikel(1);
			a.setNaam("sporthoed");
			service.updateArtikel(a);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	private Artikel maakArtikel(String naam) {
		Artikel artikel = new Artikel();
		artikel.setNaam(naam);
		artikel.setAantal(3);
		Double prijs = new Double(4.99);
		artikel.setPrijs(prijs);
		return artikel;
	}

}
