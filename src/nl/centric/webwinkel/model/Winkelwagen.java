package nl.centric.webwinkel.model;

import java.util.List;
import java.util.Map;

public class Winkelwagen {
	
	private Map<Integer, Integer> inhoud;
	private List<Artikel> artikelen;
	
	public Map<Integer, Integer> getInhoud() {
		return inhoud;
	}
	public void setInhoud(Map<Integer, Integer> inhoud) {
		this.inhoud = inhoud;
	}
	public List<Artikel> getArtikelen() {
		return artikelen;
	}
	public void setArtikelen(List<Artikel> artikelen) {
		this.artikelen = artikelen;
	}
	
}
