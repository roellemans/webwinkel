package nl.centric.webwinkel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {

	@Id
	private String gebruikersnaam;
	private String wachtwoord;
	
	public Login() {}
	
	public Login(String gebruikersnaam, String wachtwoord){
		this.gebruikersnaam = gebruikersnaam;
		this.wachtwoord = wachtwoord;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	

}
