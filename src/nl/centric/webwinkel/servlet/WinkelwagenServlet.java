package nl.centric.webwinkel.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class WinkelwagenServlet
 */
@WebServlet(urlPatterns = {"/Winkelwagen"})
public class WinkelwagenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WinkelwagenServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/winkelwagen.jsp");
		request.setAttribute("winkelwagen", session.getAttribute("winkelwagen"));
		dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
