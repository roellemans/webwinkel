package nl.centric.webwinkel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OurServlet
 */
@WebServlet(urlPatterns = { "*.roel" },
			initParams = {@WebInitParam(name="ProductName",value="Welcome to Webwinkel Roellemans")})
public class OurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String appName = "Webwinkel Roellemans";

	public OurServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		appName = getInitParameter("ProductName");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null && name != "") {
			response.setContentType("text/xml");
			response.getWriter().printf("<application>"
					+ "<name>Hello %s</name>" 
					+ "<product> %s </product>"
					+ "</application>", name, appName);
		} else {
			throw new ServletException("A name should be entered");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null && name != "") {
			response.getWriter().printf("Hello %s", name);
		} else {
			response.sendRedirect("winkel.jsp");
		}
	}

}
