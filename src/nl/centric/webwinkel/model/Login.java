package nl.centric.webwinkel.model;

public class Login {

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
