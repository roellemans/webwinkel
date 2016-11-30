package nl.centric.webwinkel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.centric.webwinkel.dao.ArtikelDao;
import nl.centric.webwinkel.model.Artikel;
import nl.centric.webwinkel.model.Magazijn;


@Service
public class ArtikelService {
	
	@Autowired
	private ArtikelDao artikelDao;
	
	@Transactional
	public void addArtikel(Artikel a){
		artikelDao.addArtikel(a);
	}
	@Transactional
	public void removeArtikel(Artikel a){
		artikelDao.removeArtikel(a);
	}
	@Transactional
	public void updateArtikel(Artikel a){
		artikelDao.updateArtikel(a);
	}
	@Transactional
	public List<Artikel> getArtikelen() throws Exception{
		return artikelDao.getArtikelen();
	}
	@Transactional
	public Artikel getArtikel(int id) throws Exception{
		return artikelDao.getArtikel(id);
	}
	@Transactional
	public Magazijn vulMagazijn() throws Exception{
		Magazijn magazijn = new Magazijn();
		magazijn.setVoorraad(artikelDao.getArtikelen());
		return magazijn;
	}

}
