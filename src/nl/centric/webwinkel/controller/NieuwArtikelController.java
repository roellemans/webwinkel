package nl.centric.webwinkel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.centric.webwinkel.model.Artikel;
import nl.centric.webwinkel.model.Magazijn;
import nl.centric.webwinkel.service.ArtikelService;

@Controller
public class NieuwArtikelController {

	@Autowired
	private ArtikelService artikelService;
	private static final String VIEW_WINKEL = "winkel";
	private static final String VIEW_NIEUWARTIKEL = "nieuwArtikel";
	private static final String VIEW_ERROR = "error";

	@RequestMapping(value = "/Winkel/NieuwArtikel", method = RequestMethod.GET)
	public String doGetNieuwArtikel( HttpServletRequest request, HttpServletResponse response) {
		return VIEW_NIEUWARTIKEL;
	}

	@RequestMapping(value = "/Winkel/NieuwArtikel", method = RequestMethod.POST)
	protected String doPostNieuwArtikel(@ModelAttribute(value="artikel") Artikel artikel,HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Magazijn magazijn = new Magazijn();
		try {
			artikelService.addArtikel(artikel);
			magazijn = artikelService.vulMagazijn();
		} catch (Exception e) {
			e.printStackTrace();
			return VIEW_ERROR;
		}
		HttpSession sessie = request.getSession();
		sessie.setAttribute("magazijn", magazijn);
		return VIEW_WINKEL;
	}
}
