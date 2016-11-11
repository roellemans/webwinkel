package nl.centric.webwinkel.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import nl.centric.webwinkel.model.Artikel;

@Stateful
public class ArtikelDao {
	
	private EntityManagerFactory emf;
	private EntityManager entityManager;

	public ArtikelDao() {
		emf = Persistence.createEntityManagerFactory("webwinkel");
		entityManager = emf.createEntityManager();
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
