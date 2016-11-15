package nl.centric.webwinkel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import nl.centric.webwinkel.dao.ArtikelDao;
import nl.centric.webwinkel.model.Artikel;
import nl.centric.webwinkel.model.Magazijn;

@Transactional
@Service
public class ArtikelService {
	
	private ArtikelDao dao = new ArtikelDao();

	public void addArtikel(Artikel a){
		dao.addArtikel(a);
	}
	
	public void removeArtikel(Artikel a){
		dao.removeArtikel(a);
	}
	
	public void updateArtikel(Artikel a){
		dao.updateArtikel(a);
	}
	
	public List<Artikel> getArtikelen() throws Exception{
		return dao.getArtikelen();
	}
	
	public Artikel getArtikel(int id) throws Exception{
		return dao.getArtikel(id);
	}
	
	public Magazijn vulMagazijn() throws Exception{
		Magazijn magazijn = new Magazijn();
		magazijn.setVoorraad(dao.getArtikelen());
		return magazijn;
	}

}
