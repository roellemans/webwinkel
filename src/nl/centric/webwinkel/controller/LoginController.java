package nl.centric.webwinkel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nl.centric.webwinkel.model.Login;
import nl.centric.webwinkel.model.Magazijn;
import nl.centric.webwinkel.service.ArtikelService;

@Controller
public class LoginController {
	@Autowired
	private ArtikelService artikelService;
	private static final String VIEW_LOGIN = "login";
	private static final String VIEW_WINKEL = "winkel";
	private static final String VIEW_ERROR = "error";

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String init(){
		return VIEW_LOGIN;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@RequestParam("gebruikersnaam") String gebruikersnaam,
			@RequestParam("wachtwoord") String wachtwoord, HttpServletRequest request, HttpServletResponse response) {

		if (gebruikersnaam != null && wachtwoord != null) {
			Login login = new Login(gebruikersnaam, wachtwoord);
			if (loginIsGeldig(login)) {
				HttpSession sessie = request.getSession();
				sessie.setAttribute("login", login);
				return vulMagazijn(request);
			} else {
				return VIEW_LOGIN;
			}
		} else {
			return VIEW_LOGIN;
		}
	}
	
	private String vulMagazijn(HttpServletRequest request){
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

	private boolean loginIsGeldig(Login login) {
		if ("Admin".equals(login.getGebruikersnaam()) && "Admin".equals(login.getWachtwoord())) {
			return true;
		}
		return false;
	}
}
