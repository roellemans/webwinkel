package nl.centric.webwinkel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import nl.centric.webwinkel.model.Artikel;


@Repository("dao")
public class ArtikelDao {
		
	@PersistenceContext
	private EntityManager entityManager;

	public ArtikelDao() {
	}
	
	public void addArtikel(Artikel a){
		entityManager.getTransaction().begin();
		entityManager.persist(a);
		entityManager.getTransaction().commit();
	}
	
	public void updateArtikel(Artikel a){
		entityManager.getTransaction().begin();
		entityManager.merge(a);
		entityManager.getTransaction().commit();
	}
	
	public void removeArtikel(Artikel a){
		entityManager.getTransaction().begin();
		entityManager.remove(a);
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Artikel> getArtikelen() throws Exception {
        Query query = entityManager.createQuery("SELECT a from Artikel as a");
        return query.getResultList();
    }
	
	public Artikel getArtikel(int id) throws Exception {
        Query query = entityManager.createQuery("SELECT a from Artikel as a where a.id = :id");
        query.setParameter("id" , id);
        return (Artikel) query.getSingleResult();
    }
}
