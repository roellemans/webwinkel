package nl.centric.webwinkel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nl.centric.webwinkel.model.Magazijn;
import nl.centric.webwinkel.model.Users;
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
	private static final String VIEW_WINKEL = "winkel";
	private static final String VIEW_ERROR = "error";
	private static final String VIEW_REGISTREER = "registreer";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(ModelMap model) {
		System.out.println("in login method");
		return VIEW_LOGIN;
	}
	
	@RequestMapping(value = "/loginMislukt", method = RequestMethod.GET)
	public String misluktLogin(ModelMap model) {
		System.out.println("in login mislukt function");
		
		model.addAttribute("error", "Gebruikersnaam of wachtwoord komt niet overeen");
		return VIEW_LOGIN;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

/*		// kan dit in een statement?
		// request.getSession().invalidate(); werkt niet
		request.getSession().setAttribute("magazijn", null);
		request.getSession().setAttribute("winkelwagen", null);
		request.getSession().setAttribute("user", null);*/
		return VIEW_LOGOUT;
	}
	
}
