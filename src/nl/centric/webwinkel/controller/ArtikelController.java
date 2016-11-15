package nl.centric.webwinkel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import nl.centric.webwinkel.model.Artikel;
import nl.centric.webwinkel.model.Magazijn;
import nl.centric.webwinkel.service.ArtikelService;

@Controller
public class ArtikelController {

	@Autowired
	private ArtikelService service;

	@RequestMapping(value = "/artikelOverzicht", method = RequestMethod.GET)
	public Artikel getArtikel(@PathParam("id") int id) {
		try {
			if (id > 0) {
				return service.getArtikel(id);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * naarWinkel
	 */
	@RequestMapping(params = "naarWinkel", method = RequestMethod.POST)
	public String naarWinkel(SessionStatus session, HttpServletRequest request){
		String returnValue = "winkel.jsp";
		try {
			Magazijn magazijn = service.vulMagazijn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
}
