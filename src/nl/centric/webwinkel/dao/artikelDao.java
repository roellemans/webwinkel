package nl.centric.webwinkel.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import nl.centric.webwinkel.model.Artikel;

@Stateful
public class artikelDao {
	@PersistenceContext(unitName = "Webwinkel", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
	
	public void addArtikel(Artikel a){
		 entityManager.persist(a);
	}
	
	public void updateArtikel(Artikel a){
		 entityManager.merge(a);
	}
	
	public void removeArtikel(Artikel a){
		 entityManager.remove(a);
	}
	
	@SuppressWarnings("unchecked")
	public List<Artikel> getAlleArtikelen() throws Exception {
        Query query = entityManager.createQuery("SELECT a from Atikel as a");
        return query.getResultList();
    }
}
