package nl.centric.webwinkel.controller;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.centric.webwinkel.model.Artikel;
import nl.centric.webwinkel.service.ArtikelService;

@Controller
public class ArtikelController {
	
	@Autowired
	private ArtikelService service;
	
	@RequestMapping(value="/artikelOverzicht", method = RequestMethod.GET)
	public Artikel getArtikel(@PathParam("id") int id) {
		try {
			return service.getArtikel(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
