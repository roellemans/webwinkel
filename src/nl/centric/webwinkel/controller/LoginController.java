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
	private static final String VIEW_WINKEL = "Winkel";
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
	
	private String vulMagazijn(HttpServletRequest request, HttpServletResponse response){
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
			for(Login log : loginLijst){
				if (log.getGebruikersnaam().equals(login.getGebruikersnaam()) &&
					log.getWachtwoord().equals(login.getWachtwoord())){
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
}
