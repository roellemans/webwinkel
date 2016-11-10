package nl.centric.webwinkel.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Artikel {
	
	@Id
	private int id;
	private String naam;
	private int aantal;
	private BigDecimal prijs;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public int getAantal() {
		return aantal;
	}
	public void setAantal(int aantal) {
		this.aantal = aantal;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	
	public boolean isOpVoorraad(int aantal){
		if (this.aantal < aantal){
			return false;
		}
		return true;
	}

}
