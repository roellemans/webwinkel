package nl.centric.webwinkel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final String VIEW_LOGIN = "login";
	private static final String VIEW_LOGOUT = "logout";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(ModelMap model) {
		return VIEW_LOGIN;
	}
	
	@RequestMapping(value = "/loginMislukt", method = RequestMethod.GET)
	public String misluktLogin(ModelMap model) {
		model.addAttribute("error", "Gebruikersnaam of wachtwoord komt niet overeen");
		return VIEW_LOGIN;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return VIEW_LOGOUT;
	}
	
}
