package nl.centric.webwinkel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	private static final String VIEW_WINKEL = "Winkel";
	private static final String VIEW_NIEUWARTIKEL = "nieuwArtikel";
	private static final String VIEW_ERROR = "error";

	@RequestMapping(value = "/Winkel/NieuwArtikel", method = RequestMethod.GET)
	public String doGetNieuwArtikel( HttpServletRequest request, HttpServletResponse response) {
		return VIEW_NIEUWARTIKEL;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/Winkel/NieuwArtikel", method = RequestMethod.POST)
	protected String doPostNieuwArtikel(@ModelAttribute(value="artikel") Artikel artikel,HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			artikelService.addArtikel(artikel);
		} catch (Exception e) {
			e.printStackTrace();
			return VIEW_ERROR;
		}
		herlaadMagazijn(request, response);
		return "redirect:/" + VIEW_WINKEL;
	}
	
	private void herlaadMagazijn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Magazijn magazijn = new Magazijn();
		try {
			magazijn = artikelService.vulMagazijn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession sessie = request.getSession();
		sessie.setAttribute("magazijn", magazijn);
	}
}
