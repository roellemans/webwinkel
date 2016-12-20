package nl.centric.webwinkel.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authorities implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Embedded
	@Id
	AuthoritiesPK authorityPK;
	
	public Authorities(){
	}
	
	public Authorities(AuthoritiesPK authorityPk){
		this.authorityPK = authorityPk;
	}
	
	public AuthoritiesPK getAuthorityPK() {
		return authorityPK;
	}

	public void setAuthorityPK(AuthoritiesPK authorityPK) {
		this.authorityPK = authorityPK;
	}
	
}
