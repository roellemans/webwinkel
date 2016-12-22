package nl.centric.webwinkel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.centric.webwinkel.model.Authorities;
import nl.centric.webwinkel.model.AuthoritiesPK;
import nl.centric.webwinkel.model.Users;
import nl.centric.webwinkel.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	private static final String VIEW_LOGIN = "login";
	private static final String VIEW_LOGOUT = "logout";
	private static final String VIEW_REGISTREER = "registreer";

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
	
	@RequestMapping(value = "/Registreer", method = RequestMethod.GET)
	public String initRegistreer(ModelMap model) {
		return VIEW_REGISTREER;
	}
	
	@RequestMapping(value = "/Registreer", method = RequestMethod.POST)
	public String registreren(@ModelAttribute("userForm") Users user, ModelMap model) {
		user.setEnabled(true);
		user.setPassword(hashPassword(user.getPassword()));
		loginService.addUser(user);
		AuthoritiesPK authorityPk = new AuthoritiesPK(user.getUsername(), "ROLE_USER");
		Authorities authority = new Authorities(authorityPk);
		loginService.addAuthority(authority);
		return "redirect:/" + VIEW_LOGIN;
	}
	
	private String hashPassword(String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashPassword = passwordEncoder.encode(password);
		return hashPassword;
	}
	
}
