package nl.centric.webwinkel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.centric.webwinkel.model.Artikel;
import nl.centric.webwinkel.model.Magazijn;
import nl.centric.webwinkel.model.Winkelwagen;
import nl.centric.webwinkel.service.ArtikelService;

/**
 * Servlet implementation class WinkelServlet
 */
@WebServlet(urlPatterns = { "/Winkel" })
public class WinkelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtikelService service;
	private Winkelwagen winkelwagen;

	public WinkelServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Magazijn magazijn = new Magazijn();
		service = new ArtikelService();
		try {
			magazijn = service.vulMagazijn();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/winkel.jsp");
		request.setAttribute("magazijn", magazijn);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service = new ArtikelService();
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
			Artikel a = service.getArtikel(id);
			lijst.add(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		winkelwagen.setArtikelen(lijst);
		winkelwagen.setInhoud(map);
		session.setAttribute("winkelwagen", winkelwagen);

		doGet(request, response);
	}

}
