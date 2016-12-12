package nl.centric.webwinkel.controller;

import java.util.List;

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
import nl.centric.webwinkel.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private ArtikelService artikelService;
	@Autowired
	private LoginService loginService;
	private static final String VIEW_LOGIN = "login";
	private static final String VIEW_LOGOUT = "logout";
	private static final String VIEW_WINKEL = "Winkel";
	private static final String VIEW_ERROR = "error";
	private static final String VIEW_REGISTREER = "registreer";

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String init() {
		return VIEW_LOGIN;
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String submit(@RequestParam("gebruikersnaam") String gebruikersnaam,
			@RequestParam("wachtwoord") String wachtwoord, HttpServletRequest request, HttpServletResponse response) {

		if (gebruikersnaam != null && wachtwoord != null) {
			Login login = new Login(gebruikersnaam, wachtwoord);
			if (loginIsGeldig(request, login)) {
				HttpSession sessie = request.getSession();
				sessie.setAttribute("login", login);
				return vulMagazijn(request, response);
			} else {
				return VIEW_LOGIN;
			}
		} else {
			return VIEW_LOGIN;
		}
	}

	private String vulMagazijn(HttpServletRequest request, HttpServletResponse response) {
		Magazijn magazijn = new Magazijn();
		try {
			magazijn = artikelService.vulMagazijn();
		} catch (Exception e) {
			e.printStackTrace();
			return VIEW_ERROR;
		}
		HttpSession sessie = request.getSession();
		sessie.setAttribute("magazijn", magazijn);
		return "redirect:/" + VIEW_WINKEL;
	}

	private boolean loginIsGeldig(HttpServletRequest request, Login login) {
		try {
			List<Login> loginLijst = loginService.getAllLogins();
			for (Login log : loginLijst) {
				if (log.getGebruikersnaam().equals(login.getGebruikersnaam())
						&& log.getWachtwoord().equals(login.getWachtwoord())) {
					return true;
				}
			}
			request.setAttribute("error", "Gebruikersnaam en/of wachtwoord komen niet overeen");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		// kan dit in een statement?
		// request.getSession().invalidate(); werkt niet
		request.getSession().setAttribute("magazijn", null);
		request.getSession().setAttribute("winkelwagen", null);
		request.getSession().setAttribute("login", null);
		return VIEW_LOGOUT;
	}

	@RequestMapping(value = "/Registreer", method = RequestMethod.GET)
	public String doGetRegistreren(HttpServletRequest request, HttpServletResponse response) {
		return VIEW_REGISTREER;
	}

	@RequestMapping(value = "/Registreer", method = RequestMethod.POST)
	public String doPostRegistreren(@RequestParam("gebruikersnaam") String gebruikersnaam,
			@RequestParam("wachtwoord") String wachtwoord, @RequestParam("hwachtwoord") String hwachtwoord,
			@RequestParam("email") String email, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("wachtwoord = " + wachtwoord);
		System.out.println("h wachtwoord = " + hwachtwoord);
		if (wachtwoord.equals(hwachtwoord)) {
			Login login = new Login(gebruikersnaam, wachtwoord, email);
			loginService.addLogin(login);
			return "redirect:/Login";
		} else {
			request.setAttribute("error", "Wachtwoorden komen niet overeen!");
			return VIEW_REGISTREER;
		}
		
	}
}
