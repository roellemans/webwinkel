package nl.centric.webwinkel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nl.centric.webwinkel.model.Artikel;
import nl.centric.webwinkel.model.Magazijn;
import nl.centric.webwinkel.model.Winkelwagen;
import nl.centric.webwinkel.service.ArtikelService;

@Controller
public class ArtikelController {
	@Autowired
	private ArtikelService artikelService;
	private static final String VIEW_WELKOM = "welkom";
	private static final String VIEW_WINKEL = "winkel";
	private static final String VIEW_ARTIKEL = "artikel";
	private static final String VIEW_ERROR = "error";
	private static final String VIEW_WINKELWAGEN = "winkelwagen";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		return VIEW_WELKOM;
	}

	@RequestMapping(value = "/Winkel", method = RequestMethod.GET)
	public String doGetWinkel(HttpServletRequest request, HttpServletResponse response) {
		Magazijn magazijn = new Magazijn();
		try {
			magazijn = artikelService.vulMagazijn();
		} catch (Exception e) {
			e.printStackTrace();
			return VIEW_ERROR;
		}
		HttpSession sessie = request.getSession();
		sessie.setAttribute("magazijn", magazijn);
		return VIEW_WINKEL;
	}
	
	@RequestMapping(value = "/Winkel/Artikel", method = RequestMethod.GET)
	public String doGetWinkelArtikel(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) {
		Artikel artikel;
		try {
			artikel = artikelService.getArtikel(id);
		} catch (Exception e) {
			e.printStackTrace();
			return VIEW_ERROR;
		}
		HttpSession sessie = request.getSession();
		sessie.setAttribute("artikel", artikel);
		return VIEW_ARTIKEL;
	}
	
	@RequestMapping(value = "/Winkel/Artikel", method = RequestMethod.POST)
	public String doPostWinkelArtikel(@ModelAttribute("artikelForm") Artikel artikel, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		try {
			artikelService.updateArtikel(artikel);
		} catch (Exception e) {
			e.printStackTrace();
			return VIEW_ERROR;
		}
		HttpSession sessie = request.getSession();
		sessie.setAttribute("artikel", artikel);
		model.addAttribute("bewerking", "Artikel is bijgewerkt");
		return VIEW_ARTIKEL;
	}

	@RequestMapping(value = "/Winkel", method = RequestMethod.POST)
	protected String doPostWinkel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<Integer, Integer> map;
		List<Artikel> lijst;
		int id = Integer.parseInt(request.getParameter("id"));
		Winkelwagen winkelwagen;
		if (session.getAttribute("winkelwagen") != null) {
			winkelwagen = (Winkelwagen) session.getAttribute("winkelwagen");
			map = winkelwagen.getInhoud();
			map.put(map.size() + 1, id);
			lijst = winkelwagen.getArtikelen();
		} else {
			winkelwagen = new Winkelwagen();
			map = new HashMap<>();
			map.put(1, id);
			lijst = new ArrayList<>();
		}
		try {
			Artikel a = artikelService.getArtikel(id);
			lijst.add(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		winkelwagen.setArtikelen(lijst);
		winkelwagen.setInhoud(map);
		session.setAttribute("winkelwagen", winkelwagen);
		return VIEW_WINKEL;
	}
	
	@RequestMapping(value = "/Winkelwagen", method = RequestMethod.GET)
	public String doGetWinkelwagen(HttpServletRequest request, HttpServletResponse response) {
		return VIEW_WINKELWAGEN;
	}
}
