package nl.centric.webwinkel.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.centric.webwinkel.model.Magazijn;
import nl.centric.webwinkel.service.ArtikelService;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(urlPatterns = {"/Winkel"})
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtikelService service;

	public ControllerServlet() {
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
	}

}
