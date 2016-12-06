package nl.centric.webwinkel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nl.centric.webwinkel.model.Artikel;

@Repository
public class ArtikelDao {

	@PersistenceContext
	private EntityManager entityManager;

	public ArtikelDao() {
	}

	@Transactional
	public void addArtikel(Artikel a) {
		entityManager.persist(a);
	}

	@Transactional
	public void updateArtikel(Artikel a) {
		entityManager.merge(a);
	}

	@Transactional
	public void removeArtikel(Artikel a) {
		entityManager.remove(a);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Artikel> getArtikelen() throws Exception {
		Query query = entityManager.createQuery("SELECT a from Artikel as a");
		return query.getResultList();
	}

	@Transactional
	public Artikel getArtikel(int id) throws Exception {
		Query query = entityManager.createQuery("SELECT a from Artikel as a where a.id = :id");
		query.setParameter("id", id);
		return (Artikel) query.getSingleResult();
	}
}
