package nl.centric.webwinkel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.centric.webwinkel.model.Artikel;
import nl.centric.webwinkel.model.Magazijn;
import nl.centric.webwinkel.model.Winkelwagen;
import nl.centric.webwinkel.service.ArtikelService;

@Controller
@RequestMapping(value = "/Winkel")
public class ArtikelController {
	@Autowired
	private ArtikelService artikelService;
	private Winkelwagen winkelwagen;

	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		Magazijn magazijn = new Magazijn();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		artikelService = ctx.getBean(ArtikelService.class);
		try {
			magazijn = artikelService.vulMagazijn();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		HttpSession sessie = request.getSession();
		sessie.setAttribute("magazijn", magazijn);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<Integer, Integer> map;
		List<Artikel> lijst;
		int id = Integer.parseInt(request.getParameter("id"));
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

	}
}
