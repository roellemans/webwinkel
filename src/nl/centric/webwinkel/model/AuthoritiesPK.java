package nl.centric.webwinkel.model;

import javax.persistence.Embeddable;

@Embeddable 
public class AuthoritiesPK implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	String username;
	String authority;
	
	public AuthoritiesPK(){
	}
	
	public AuthoritiesPK(String username, String authority){
		this.username = username;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
